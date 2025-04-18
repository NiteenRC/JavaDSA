package programs.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileReaderExample {
    private static final int FILE_COUNT = 10;

    public static void main(String[] args) throws Exception {
        runSingleThreaded();
        runMultiThreaded();
    }

    private static void runSingleThreaded() throws InterruptedException {
        System.out.println("\n--- File Reading: Single-Threaded ---");
        long start = System.currentTimeMillis();

        int totalWords = 0;
        for (int i = 1; i <= FILE_COUNT; i++) {
            totalWords += readFile(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Total words: " + totalWords);
        System.out.println("Time taken (single-threaded): " + (end - start) + "ms");
    }

    private static void runMultiThreaded() throws Exception {
        System.out.println("\n--- File Reading: Multi-Threaded ---");
        int threadCount = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 1; i <= FILE_COUNT; i++) {
            final int fileNum = i;
            results.add(executor.submit(() -> readFile(fileNum)));
        }

        int totalWords = 0;
        for (Future<Integer> future : results) {
            totalWords += future.get();
        }

        executor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("Total words: " + totalWords);
        System.out.println("Time taken (multi-threaded): " + (end - start) + "ms");
    }

    private static int readFile(int fileNum) throws InterruptedException {
        // Simulate I/O delay and word counting
        Thread.sleep(200); // Simulate delay
        return 100 + fileNum; // Dummy word count
    }
}