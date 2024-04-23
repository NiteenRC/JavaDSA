package interview.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileWordCharCount {
    public static void main(String[] args) {
        String filePath = "your_file_path.txt"; // Update with the path to your file

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            long wordCount = lines.flatMap(line -> Stream.of(line.split("\\s+")))
                    .count(); // Count total words

            long charCount = lines.flatMapToInt(String::chars)
                    .count(); // Count total characters

            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of characters: " + charCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}