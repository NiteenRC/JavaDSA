package programs.threads;

import java.util.stream.IntStream;

public class ThreadPrintNumbers {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            IntStream.range(0, 5).forEach(System.out::println);
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
