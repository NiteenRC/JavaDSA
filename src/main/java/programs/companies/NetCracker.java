package programs.companies;

import java.util.*;

/**
 * Interview Question:
 *
 * 1. Implement a method to find the second most frequent words in a given text.
 * - Ignore special characters and consider only letters and digits.
 * - Return a list of words that have the second highest frequency.
 *
 * Example:
 * Input: "Hello world!!! This is Aakash. Friends call me Aakash the great. I want to be world famous celebrity and open Aakash group of companies"
 * Output: [world, great, want, be, famous, celebrity, open, group, of, companies]
 *
 * 2. Implement a method to group anagrams from a list of words.
 * - Anagrams are words that can be formed by rearranging the letters of another word.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
 *
 * Consider edge cases such as empty text, single word text, or lists with no anagrams.
 */
public class NetCracker {
    public static void main(String[] args) {
        // Find the second most frequent words in the given text.
        String inputText = "Hello world!!! This is Aakash. Friends call me Aakash the great. I want to be world famous celebrity and open Aakash group of companies";
        List<String> secondMostFrequentWords = findSecondMostFrequentWords(inputText);
        if (secondMostFrequentWords != null) {
            System.out.println("Second most frequent words: " + secondMostFrequentWords);
        } else {
            System.out.println("No second most frequent words found.");
        }

        // Example usage of the groupAnagrams method
        String[] wordsArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagramGroups = groupAnagrams(wordsArray);
        System.out.println("Anagram groups: " + anagramGroups);
    }

    public static List<String> findSecondMostFrequentWords(String text) {
        // Step 1: Remove special characters
        StringBuilder cleanedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetterOrDigit(ch) || ch == ' ') {
                cleanedText.append(ch);
            }
        }
        System.out.println("Removed special characters: " + cleanedText);

        // Step 2: Count word frequencies
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : cleanedText.toString().split("\\s+")) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 3: Group words by frequency
        Map<Integer, List<String>> frequencyGroups = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            frequencyGroups.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        // Step 4: Find second most frequent words
        ArrayList<Map.Entry<Integer, List<String>>> frequencies = new ArrayList<>(frequencyGroups.entrySet());
        if (frequencies.size() > 1) {
            return frequencies.get(1).getValue(); // Second highest frequency
        } else {
            return null;
        }
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            anagramMap.computeIfAbsent(sortedWord, key -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(anagramMap.values());
    }
}