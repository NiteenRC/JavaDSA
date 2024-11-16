package design.pattern.creational.singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

enum ResourceManager {
    INSTANCE;
    private final Path resourceDirectory = Paths.get("/Users/niteenchougula/Documents/logs/");

    public BufferedReader openFile(String fileName) throws IOException {
        Path filePath = resourceDirectory.resolve(fileName);
        if (!Files.exists(filePath)) {
            Files.createDirectories(resourceDirectory);
            Files.createFile(filePath);
        }
        return Files.newBufferedReader(filePath);
    }

    public void closeFile(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(); // or handle the exception
        }
    }
}

public class ResourceManagerImpl {
    public static void main(String[] args) {
        ResourceManager resourceManager = ResourceManager.INSTANCE;

        try (BufferedReader reader = resourceManager.openFile("resource1.txt")) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // Close the file
            resourceManager.closeFile(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
