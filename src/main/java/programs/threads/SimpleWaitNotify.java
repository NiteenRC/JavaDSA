package programs.threads;

public class SimpleWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        SimpleWaitNotify simpleWaitNotify = new SimpleWaitNotify();

        Thread producerThread = new Thread(() -> {
            try {
                simpleWaitNotify.producer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                simpleWaitNotify.consumer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    private synchronized void producer() throws InterruptedException {
        System.out.println("producer started");
        wait();
        System.out.println("producer stopped");
    }

    private synchronized void consumer() throws InterruptedException {
        System.out.println("consumer started");
        notify();
        System.out.println("consumer stopped");
    }
}