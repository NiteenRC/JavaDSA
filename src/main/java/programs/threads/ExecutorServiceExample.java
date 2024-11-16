package programs.threads;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Record the start time of execution
        long startTime = System.nanoTime();

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + cores);

        // Create an ExecutorService with a fixed thread pool size based on available processors
        ExecutorService executorService = Executors.newFixedThreadPool(cores);

        // Define the total number of iterations and number of threads (we split the task into equal chunks)
        int totalIterations = 1000000; // Increased iterations
        int numThreads = cores; // Number of threads is equal to the number of available processors
        int chunkSize = totalIterations / numThreads;

        // Submit tasks to the executor service
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? totalIterations : (i + 1) * chunkSize;
            executorService.submit(new Task(start, end));
        }

        // Shut down the executor service after use
        executorService.shutdown();

        try {
            // Wait for all tasks to finish (with a timeout)
            boolean finished = executorService.awaitTermination(1, TimeUnit.HOURS);
            if (!finished) {
                System.out.println("Timeout occurred before task completion.");
            }
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted.");
            Thread.currentThread().interrupt();
        }

        // Record the end time of execution
        long endTime = System.nanoTime();

        // Calculate and print the execution time
        long duration = endTime - startTime;  // duration in nanoseconds
        System.out.println("Execution time with multiple threads: " + duration / 1_000_000 + " milliseconds");
    }
}

// Task class that implements Runnable and defines the task's behavior
class Task implements Runnable {
    private final int start;
    private final int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        // Perform work for the specified range of iterations
        for (int i = start; i < end; i++) {
            executeTask();
        }
    }

    private void executeTask() {
        // Simulate task work (e.g., computation or other logic)
        // In this case, the task just prints a message (you can replace this with actual logic)
        // System.out.println("Task assigned");
    }
}
