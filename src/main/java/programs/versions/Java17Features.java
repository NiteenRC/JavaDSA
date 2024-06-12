package programs.versions;

import java.util.List;
import java.util.concurrent.*;
import java.util.random.RandomGenerator;

public class Java17Features {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. Sealed Classes
        System.out.println("=== Sealed Classes ===");
        Shape shape = new Circle();
        System.out.println("Shape: " + shape.describe());

        // 2. Pattern Matching for switch
        System.out.println("\n=== Pattern Matching for switch ===");
        Number num = 42;
        System.out.println("Number type: " + getType(num));

        // 3. Enhanced Random Number Generators
        System.out.println("\n=== Enhanced Random Number Generators ===");
        RandomGenerator randomGenerator = RandomGenerator.of("L64X128MixRandom");
        System.out.println("Random int: " + randomGenerator.nextInt());

        // 5. Pattern Matching for instanceof
        System.out.println("\n=== Pattern Matching for instanceof ===");
        Object obj = "Hello, Java 17!";
        if (obj instanceof String str) {
            System.out.println("String content: " + str);
        }

        // 6. Asynchronous URL Processing (ExecutorService)
        System.out.println("\n=== Asynchronous URL Processing ===");
        List<String> urls = List.of("https://www.example.com", "https://www.example.org", "https://www.example.net");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = urls.stream()
                .map(url -> executor.submit(createFetchUrlTask(url)))
                .toList();

        // Process results asynchronously as they become available
        for (Future<String> future : futures) {
            System.out.println("Fetched content: " + future.get());
        }
        // Shutdown the executor
        executor.shutdown();

        // 7. Always-Strict Floating-Point Semantics
        System.out.println("\n=== Always-Strict Floating-Point Semantics ===");
        double a = 0.1;
        double b = 0.2;
        double sumAB = a + b;
        System.out.println("Sum of 0.1 and 0.2 (strict floating point): " + sumAB);
    }

    // Helper method for pattern matching with switch
    private static String getType(Number number) {
        return switch (number) {
            case Integer i -> "Integer";
            case Double d -> "Double";
            case Long l -> "Long";
            default -> "Unknown";
        };
    }

    // Helper method to create a Callable task for fetching URL content
    private static Callable<String> createFetchUrlTask(String url) {
        return () -> {
            try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.net.URL(url).openStream()))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            } catch (java.io.IOException e) {
                return "Error fetching content from " + url + ": " + e.getMessage();
            }
        };
    }

    // Sealed classes example
    public static abstract sealed class Shape permits Circle, Square, Rectangle {
        abstract String describe();
    }

    public static final class Circle extends Shape {
        @Override
        public String describe() {
            return "I am a Circle";
        }
    }

    public static final class Rectangle extends Shape {
        @Override
        public String describe() {
            return "I am a Rectangle";
        }
    }

    public static non-sealed class Square extends Shape {
        @Override
        public String describe() {
            return "I am a Square";
        }
    }
}