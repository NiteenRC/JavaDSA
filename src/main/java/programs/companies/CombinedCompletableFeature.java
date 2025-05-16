package programs.companies;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class CombinedCompletableFeature {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<List<Driver>> future1 = CompletableFuture.supplyAsync(CombinedCompletableFeature::fetchDataset1, executor);
        CompletableFuture<List<Driver>> future2 = CompletableFuture.supplyAsync(CombinedCompletableFeature::fetchDataset2, executor);

        CompletableFuture<List<Driver>> combinedFuture = future1.thenCombine(future2, (list1, list2) ->
                Stream.concat(list1.stream(), list2.stream())
                        .toList());

        CompletableFuture<List<Driver>> filteredResult = combinedFuture.thenApply(combinedList ->
                combinedList.stream()
                        .filter(Driver -> Driver.age() > 25)
                        .toList()
        );

        List<Driver> finalResult = filteredResult.get(); // Blocking call for demonstration

        System.out.println("Filtered Drivers:");
        finalResult.forEach(System.out::println);

        executor.shutdown();
    }

    private static List<Driver> fetchDataset1() {
        sleep(1000); // simulate delay
        return List.of(
                new Driver("Alice", 30),
                new Driver("Bob", 20)
        );
    }

    private static List<Driver> fetchDataset2() {
        sleep(1500); // simulate delay
        return List.of(
                new Driver("Charlie", 40),
                new Driver("David", 22)
        );
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

record Driver(String name, int age) {
    public String toString() {
        return name + " (" + age + ")";
    }
}
