package programs.hashmap;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxRepeatedCharacter {
    public static void main(String[] args) {
        String str = "hello world";

        char maxRepeatedChar = findMaxRepeatedCharacter(str);
        System.out.println("Max repeated character: " + maxRepeatedChar);
    }

    public static char findMaxRepeatedCharacter(String str) {
        // Convert the string to a map of characters and their counts
        Map<Character, Long> charCounts = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Find the character with the maximum count
        Optional<Map.Entry<Character, Long>> maxEntry = charCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        // Return the character with the maximum count
        return maxEntry.isPresent() ? maxEntry.get().getKey() : '\0';
    }
}