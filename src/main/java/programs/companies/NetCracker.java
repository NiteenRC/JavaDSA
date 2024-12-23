package programs.companies;

import java.util.*;

public class NetCracker {
    public static void main(String[] args) {
        String s = "Hello world!!! This is Aakash. Friends call me Aakash the great. I want to be world famous celebrity and open Aakash group of companies";

        // Step 1: Remove special characters
        StringBuilder str = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch) || ch == ' ') {
                str.append(ch);
            }
        }
        System.out.println("Removed special characters: " + str);

        // Step 2: Count word frequencies
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : str.toString().split("\\s+")) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 3: Group words by frequency
        Map<Integer, List<String>> frequencyGroups = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            frequencyGroups.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        // Step 4: Find second most frequent words
        List<Integer> frequencies = new ArrayList<>(frequencyGroups.keySet());
        if (frequencies.size() > 1) {
            int secondHighestFrequency = frequencies.get(1); // Second highest frequency
            List<String> secondMostFrequentWords = frequencyGroups.get(secondHighestFrequency);
            System.out.println("Second most frequent words (frequency = " + secondHighestFrequency + "): " + secondMostFrequentWords);
        } else {
            System.out.println("No second most frequent words found.");
        }
    }
}