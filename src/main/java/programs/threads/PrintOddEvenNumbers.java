package programs.threads;

public class PrintOddEvenNumbers {
    private static final int MAX_NUMBER = 20;
    private static final Object lock = new Object();
    private static volatile int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(PrintOddEvenNumbers::printOdd);
        Thread evenThread = new Thread(PrintOddEvenNumbers::printEven);

        oddThread.start();
        evenThread.start();
    }

    private static void printOdd() {
        while (number <= MAX_NUMBER) {
            synchronized (lock) {
                if (number % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    lock.notify(); // Notify waiting threads
                } else {
                    try {
                        lock.wait(); // Wait for even thread to print
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void printEven() {
        while (number <= MAX_NUMBER) {
            synchronized (lock) {
                if (number % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    lock.notify(); // Notify waiting threads
                } else {
                    try {
                        lock.wait(); // Wait for odd thread to print
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}