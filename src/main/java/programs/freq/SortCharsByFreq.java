package programs.freq;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Interview Question:
 * Implement a method that sorts characters in a string by their frequency in descending order using Java 8 Streams.
 *
 * Given an input string, your task is to:
 * 1. Create a frequency map of characters.
 * 2. Sort the characters by their frequency in descending order.
 * 3. Return a string where characters are followed by their frequency counts.
 *
 * Example:
 * Input: "JavaJ2EEE"
 * Output: "E3J2a2v121"
 *
 * Consider edge cases such as an empty string or strings with all unique characters.
 *
 * Reference: https://leetcode.com/problems/sort-characters-by-frequency/submissions/1217971453/
 */

public class SortCharsByFreq {
    public static void main(String[] args) {
        String input = "JavaJ2EEE";
        System.out.println(sortByFreq(input));
    }

    private static String sortByFreq(String input) {
        // Step 1: Create a frequency map of characters
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Step 2: Sort the characters by their frequency in descending order
        Stream<String> sortedStream = frequencyMap.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .map(entry -> entry.getKey() + "" + entry.getValue());

        // Step 3: Join the sorted characters to form the output string
        return sortedStream.collect(Collectors.joining());
    }
}