package programs.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenNumbers {
    private static final int MAX_NUMBER = 20;
    private static final Lock lock = new ReentrantLock();
    private static int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(PrintOddEvenNumbers::printOdd, "T1");
        Thread evenThread = new Thread(PrintOddEvenNumbers::printEven, "T2");

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