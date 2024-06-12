package programs.threads;

import java.util.concurrent.*;

public class CallableThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        System.out.println("\nExecuting orderNotPreserved method:");
        orderNotPreserved();

        System.out.println("\nExecuting orderPreserved method:");
        orderPreserved();
    }

    private static void orderNotPreserved() throws InterruptedException, ExecutionException {
        // Using Callable to define the task
        Callable<String> task = () -> {
            System.out.println("Running task in thread: " + Thread.currentThread().getName());
            return "Result of orderNotPreserved Task";
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submitting the task for execution
        Future<String> future = executor.submit(task);

        // Outputs the current thread before submitting the task
        System.out.println("Before Submit: " + Thread.currentThread().getName());

        // Waits for the task to complete and retrieves the result
        String result = future.get();

        // Outputs after the task has completed and prints the result
        System.out.println("After Submit: " + Thread.currentThread().getName() + ", Result: " + result);

        // Shutting down the executor
        executor.shutdown();
    }

    private static void orderPreserved() throws InterruptedException, ExecutionException {
        // Using Callable to define the task
        Callable<String> task = () -> {
            System.out.println("Running task in thread: " + Thread.currentThread().getName());
            return "Result of orderPreserved Task";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submitting the task for execution
        Future<String> future = executor.submit(task);

        // Outputs the current thread before submitting the task
        System.out.println("Before Submit: " + Thread.currentThread().getName());

        // Waits for the task to complete and retrieves the result
        String result = future.get();

        // Outputs after the task has completed and prints the result
        System.out.println("After Submit: " + Thread.currentThread().getName() + ", Result: " + result);

        // Shutting down the executor
        executor.shutdown();
    }
}