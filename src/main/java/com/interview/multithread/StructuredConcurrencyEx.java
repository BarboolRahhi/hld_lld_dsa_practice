import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.TimeUnit;

void main() throws InterruptedException, ExecutionException {
    try(var scope = new StructuredTaskScope.ShutdownOnFailure()) {
        var task1 = scope.fork(this::task1);
        var task2 = scope.fork(this::task2);
        var start = Instant.now();
        scope.join().throwIfFailed();
        var time = Duration.between(start, Instant.now());
        System.out.println(STR."1. \{task1.get()} 2. \{task2.get()} completed in \{time}");
    }
}


String task1() throws InterruptedException {
    TimeUnit.SECONDS.sleep(1);
    return "Task 1 Completed";
}


String task2() throws InterruptedException {
    TimeUnit.SECONDS.sleep(10);
    return "Task 2 Completed";
}