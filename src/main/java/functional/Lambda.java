package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        // 1. Write a lambda expression to sort a list of strings in ascending order of length.
        List<String> list = Arrays.asList("Niteen", "Chougula", "Bangalore", "India", "Chougule");
        List<String> resultList = list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted by length: " + resultList);

        // 2. How would you use a lambda expression to define a runnable task to print "Hello, world!"?
        Runnable runnable = () -> System.out.println("Runnable task: Hello World");
        runnable.run();

        // 3. How would you use method references to sort a list of strings alphabetically?
        List<String> alphabetically = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted alphabetically: " + alphabetically);

        // 4. How would you use the Collectors class to convert a stream of strings into a single comma-separated string?
        String resultJoining = String.join(",", list);
        System.out.println("Comma-separated string: " + resultJoining);
    }
}
