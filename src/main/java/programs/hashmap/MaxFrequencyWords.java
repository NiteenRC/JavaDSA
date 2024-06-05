package programs.hashmap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxFrequencyWords {
    public static void main(String[] args) {
        String sentence = "hello world hello java world world java hello";

        List<String> maxFrequencyWords = findAllMaxFrequencyWords(sentence);
        System.out.println("Max frequency words: " + maxFrequencyWords);
    }

    public static List<String> findAllMaxFrequencyWords(String sentence) {
        // Split the sentence into words and count their occurrences
        Map<String, Long> wordCounts = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        // Find the maximum frequency
        long maxFrequency = Collections.max(wordCounts.values());
        //long maxFrequency =wordCounts.entrySet().stream().map(Map.Entry::getValue).max(Long::compareTo).get();

        // Filter out the words with the maximum frequency
        return wordCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}