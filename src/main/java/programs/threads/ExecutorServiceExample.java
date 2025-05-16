package programs.threads;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int range = 10_000_000;
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + threadCount);

        // Run single-threaded version
        runSingleThreaded(range);

        // Run multi-threaded version
        runMultiThreaded(range, threadCount);
    }

    private static void runSingleThreaded(int range) {
        System.out.println("\n--- Single-Threaded Execution ---");
        long start = System.currentTimeMillis();

        long sum = 0;
        for (int i = 1; i <= range; i++) {
            if (PrimeUtil.isPrime(i)) {
                sum += i;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Sum of primes: " + sum);
        System.out.println("Time taken (single-threaded): " + (end - start) + "ms");
    }

    private static void runMultiThreaded(int range, int threadCount) throws InterruptedException, ExecutionException {
        System.out.println("\n--- Multi-Threaded Execution ---");
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        int chunkSize = range / threadCount;

        List<Callable<Long>> tasks = IntStream.range(0, threadCount)
                .mapToObj(i -> {
                    final int startRange = i * chunkSize;
                    final int endRange = (i == threadCount - 1) ? range : (i + 1) * chunkSize;
                    return (Callable<Long>) () -> {
                        long partialSum = 0;
                        for (int j = startRange; j < endRange; j++) {
                            if (PrimeUtil.isPrime(j)) {
                                partialSum += j;
                            }
                        }
                        System.out.println("Executing in: " + Thread.currentThread().getName() + " => " + partialSum);
                        return partialSum;
                    };
                }).toList();

        List<Future<Long>> results = executor.invokeAll(tasks);

        long totalSum = 0;
        for (Future<Long> future : results) {
            totalSum += future.get();
        }

        executor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("Sum of primes: " + totalSum);
        System.out.println("Time taken (multi-threaded): " + (end - start) + "ms");
    }
}

class PrimeUtil {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}