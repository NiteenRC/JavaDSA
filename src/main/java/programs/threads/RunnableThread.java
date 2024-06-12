package programs.threads;

public class RunnableThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread name: " + Thread.currentThread().getName());

        System.out.println("\nExecuting orderNotPreserved method:");
        orderNotPreserved();

        System.out.println("\nExecuting orderPreserved method:");
        orderPreserved();
    }

    private static void orderNotPreserved() {
        // Using a lambda expression to create a Runnable
        Runnable task = () -> {
            System.out.println("Running task in thread: " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task);

        // Outputs the current thread before starting the new thread
        System.out.println("Before Start: " + Thread.currentThread().getName());
        thread.start();

        // Outputs after starting the new thread. Execution order is not guaranteed.
        System.out.println("After Start: " + Thread.currentThread().getName());
    }

    private static void orderPreserved() throws InterruptedException {
        // Using a lambda expression to create a Runnable
        Runnable task = () -> {
            System.out.println("Running task in thread: " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task);

        // Outputs the current thread before starting the new thread
        System.out.println("Before Start: " + Thread.currentThread().getName());
        thread.start();

        // Waits for the new thread to complete before continuing
        thread.join();

        // Outputs after the new thread has completed
        System.out.println("After Join: " + Thread.currentThread().getName());
    }
}