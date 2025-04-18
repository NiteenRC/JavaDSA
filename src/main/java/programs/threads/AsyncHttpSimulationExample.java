package programs.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncHttpSimulationExample {
    private static final int TASK_COUNT = 10;

    public static void main(String[] args) throws Exception {
        runSequential();
        runAsync();
    }

    private static void runSequential() {
        System.out.println("\n--- Simulated HTTP Calls: Sequential ---");
        long start = System.currentTimeMillis();

        for (int i = 1; i <= TASK_COUNT; i++) {
            simulateHttpCall(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken (sequential): " + (end - start) + "ms");
    }

    private static void runAsync() throws InterruptedException, ExecutionException {
        System.out.println("\n--- Simulated HTTP Calls: Async (CompletableFuture) ---");
        long start = System.currentTimeMillis();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 1; i <= TASK_COUNT; i++) {
            final int id = i;
            futures.add(CompletableFuture.runAsync(() -> simulateHttpCall(id)));
        }

        // Wait for all
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long end = System.currentTimeMillis();
        System.out.println("Time taken (async): " + (end - start) + "ms");
    }

    private static void simulateHttpCall(int id) {
        try {
            System.out.println("Calling API #" + id + " on thread: " + Thread.currentThread().getName());
            Thread.sleep(500); // Simulate network delay
            System.out.println("Response received for API #" + id);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
