import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RateLimiter {
    private static final int MAX_REQUESTS_PER_MINUTE = 60;
    private static final long REQUEST_INTERVAL_MS = TimeUnit.MINUTES.toMillis(1) / MAX_REQUESTS_PER_MINUTE;

    private long lastRequestTime = System.currentTimeMillis();

    public synchronized void waitForRateLimit() throws InterruptedException {
        long now = System.currentTimeMillis();
        long timeSinceLastRequest = now - lastRequestTime;

        if (timeSinceLastRequest < REQUEST_INTERVAL_MS) {
            long sleepTime = REQUEST_INTERVAL_MS - timeSinceLastRequest;
            Thread.sleep(sleepTime);
        }

        lastRequestTime = System.currentTimeMillis();
    }
}



public class TokenBucketRateLimiter {
    private final int maxTokens;
    private final long refillIntervalMillis;
    private final BlockingQueue<String> tokenBucket;
    private final ScheduledExecutorService scheduler;

    public TokenBucketRateLimiter(int maxRequestsPerMinute) {
        this.maxTokens = maxRequestsPerMinute;
        this.refillIntervalMillis = TimeUnit.MINUTES.toMillis(1) / maxRequestsPerMinute;
        this.tokenBucket = new LinkedBlockingQueue<>(maxTokens);

        // Fill the bucket initially
        for (int i = 0; i < maxTokens; i++) {
            tokenBucket.offer("");
            // 9597463797
            // 12.35
        }

        // Schedule token refills
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::refillTokens, 0, refillIntervalMillis, TimeUnit.MILLISECONDS);
    }

    private void refillTokens() {
        // Try to refill the bucket
        System.out.println("Refill");
        if (tokenBucket.size() < maxTokens) {
            tokenBucket.offer("");
        }
    }

    public void acquire() throws InterruptedException {
        // Take a token from the bucket, blocking if necessary
//        System.out.println("Acquired");
        tokenBucket.take();

    }

    public void shutdown() {
        scheduler.shutdown();
    }
}


void main() throws InterruptedException {

    var rateLimiter = new TokenBucketRateLimiter(50);


    var str = """
                hello
                yello
            """.stripIndent();
    System.out.println(str);
//    while (true) {
//        rateLimiter.acquire();
//        System.out.println("Running...");
//        System.out.println(fibonacci(2));
//    }

//    System.out.println(System.currentTimeMillis() - 0L);
}


Integer fibonacci(final int num) {
    if (num <= 0) {
        return -1;
    }
    var ans  = new ArrayList<Integer>();
    ans.add(0);
    ans.add(1);

    for (int i = 2; i < num; i++) {
        ans.add(ans.get(i - 1) + ans.get(i - 2));
    }

//    IntStream.range(2, num)
//            .map(i -> ans.get(i - 1) + ans.get(i - 2))
//            .forEach(ans::add);

    return ans.get(num - 1);
}