package programs.threads;

import java.util.*;
import java.util.concurrent.*;

public class URLFetcher {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public List<String> fetchDataFromURLs(List<String> urls) throws InterruptedException, ExecutionException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (String url : urls) {
            tasks.add(() -> {
                // Simulate fetching data from URL
                return "Data from " + url;
            });
        }

        List<Future<String>> results = executorService.invokeAll(tasks);
        List<String> fetchedData = new ArrayList<>();

        for (Future<String> result : results) {
            fetchedData.add(result.get());  // Wait for the result of each task
        }

        return fetchedData;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> urls = Arrays.asList("http://example.com", "http://example.org", "http://example.net");
        URLFetcher fetcher = new URLFetcher();
        List<String> data = fetcher.fetchDataFromURLs(urls);

        // Print out the fetched data
        data.forEach(System.out::println);

        executorService.shutdown();  // Shutdown the ExecutorService
    }
}
