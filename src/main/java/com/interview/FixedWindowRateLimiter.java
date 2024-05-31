package com.interview;

import java.util.ArrayDeque;
import java.util.Queue;

public class FixedWindowRateLimiter {
    private int maxRequests;
    private int windowSizeInSeconds;
    private Queue<Long> requestTimes;

    public FixedWindowRateLimiter(int maxRequests, int windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.requestTimes = new ArrayDeque<>();
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis() / 1000; // Convert milliseconds to seconds
        requestTimes.removeIf(time -> {
            System.out.println( currentTime - windowSizeInSeconds);
            return time < currentTime - windowSizeInSeconds ;
        });
        if (requestTimes.size() < maxRequests) {
            requestTimes.add(currentTime);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(2, 10); // Allow 5 requests per minute

        for (;;) {
            if (limiter.allowRequest()) {
                System.out.println("Request allowed");
            } else {
                System.out.println("Rate limit exceeded");
            }
            try {
                Thread.sleep(2000); // Simulate some delay between requests (10 seconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

