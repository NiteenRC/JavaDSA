package programs.threads;

public class ThreadExample {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {
                System.out.println("Thread 1 finished.");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
