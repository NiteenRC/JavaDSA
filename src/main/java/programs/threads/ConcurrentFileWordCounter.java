package programs.threads;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ConcurrentFileWordCounter {
    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
    private static final ReentrantLock lock = new ReentrantLock();
    private static int totalWordCount = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Path> files = getTextFiles("data"); // folder with .txt files

        List<CompletableFuture<Void>> futures = files.stream()
                .map(file -> CompletableFuture.supplyAsync(() -> countWords(file), executor)
                        .thenAccept(count -> {
                            lock.lock();
                            try {
                                totalWordCount += count;
                                System.out.printf("Processed %s: %d words%n", file.getFileName(), count);
                            } finally {
                                lock.unlock();
                            }
                        })
                ).toList();

        // Wait for all tasks to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Total Word Count: " + totalWordCount);
        executor.shutdown();
    }

    private static List<Path> getTextFiles(String directory) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directory), "*.txt")) {
            return StreamSupport.stream(stream.spliterator(), false).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read directory: " + directory, e);
        }
    }

    private static int countWords(Path filePath) {
        try {
            String content = Files.readString(filePath);
            return content.split("\\s+").length;
        } catch (IOException e) {
            System.err.println("Failed to read file: " + filePath);
            return 0;
        }
    }
}