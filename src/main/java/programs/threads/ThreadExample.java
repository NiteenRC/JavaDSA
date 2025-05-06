package programs.threads;

public class ThreadExample {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int count = 0;
            while (flag) {
                count++;
            }
            System.out.println("Thread 1 finished." + count);
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10);
                System.out.println("Thread 2 finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        });

        t1.start();
        t2.start();

        //t1.join();
        //t2.join();
    }
}
