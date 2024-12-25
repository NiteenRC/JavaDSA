package programs.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapCodes {
    public static void main(String[] args) {
        // 1. Group Anagrams
        System.out.println("1. Group Anagrams");
        List<List<String>> anagrams = groupAnagrams(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        System.out.println(anagrams);

        // 2. Top K Frequent Words
        System.out.println("\n2. Top K Frequent Words");
        List<String> topKWords = topKFrequentWords(Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple"), 2);
        System.out.println(topKWords);

        // 3. Sort Characters by Frequency
        System.out.println("\n3. Sort Characters by Frequency");
        String sortedByFrequency = sortCharactersByFrequency("tree");
        System.out.println(sortedByFrequency);

        // 4. Find Most Frequent Element in an Array
        System.out.println("\n4. Find Most Frequent Element in an Array");
        int mostFrequentElement = findMostFrequentElement(new int[]{1, 3, 2, 3, 1, 3, 4, 1});
        System.out.println(mostFrequentElement);

        // 5. Group People by Age
        System.out.println("\n5. Group People by Age");
        Map<Integer, List<String>> groupedByAge = groupPeopleByAge(Arrays.asList(
                new AbstractMap.SimpleEntry<>("Alice", 25),
                new AbstractMap.SimpleEntry<>("Bob", 30),
                new AbstractMap.SimpleEntry<>("Charlie", 25),
                new AbstractMap.SimpleEntry<>("David", 30),
                new AbstractMap.SimpleEntry<>("Eve", 35)));
        System.out.println(groupedByAge);

        // 6. Find All Pairs with a Given Sum
        System.out.println("\n6. Find All Pairs with a Given Sum");
        List<int[]> pairs = findPairsWithSum(new int[]{1, 2, 3, 4, 5}, 6);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        // 7. Sort Elements by Frequency
        System.out.println("\n7. Sort Elements by Frequency");
        List<Integer> sortedElements = sortByFrequency(new int[]{4, 3, 1, 6, 3, 6, 4, 4, 2});
        System.out.println(sortedElements);

        // 8. First Unique Character in a String
        System.out.println("\n8. First Unique Character in a String");
        int firstUniqueCharIndex = firstUniqueChar("loveleetcode");
        System.out.println(firstUniqueCharIndex);

        // 9. Check for Subarray with Zero Sum
        System.out.println("\n9. Check for Subarray with Zero Sum");
        boolean hasZeroSumSubarray = hasZeroSumSubarray(new int[]{4, 2, -3, 1, 6});
        System.out.println(hasZeroSumSubarray);

        // 10. Longest Consecutive Sequence
        System.out.println("\n10. Longest Consecutive Sequence");
        int longestConsecutiveSequence = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(longestConsecutiveSequence);

        // 11. Find Max Repeated Character
        System.out.println("\n11. Find Max Repeated Character");
        char maxRepeatedChar = findMaxRepeatedCharacter("teststring");
        System.out.println(maxRepeatedChar);

        // 12. Find All Max Frequency Words
        System.out.println("\n12. Find All Max Frequency Words");
        List<String> maxFreqWords = findAllMaxFrequencyWords("this is a test this is only a test");
        System.out.println(maxFreqWords);
    }

    // Group Anagrams
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    // Top K Frequent Words
    public static List<String> topKFrequentWords(List<String> words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        Collections.reverse(result); // To get the highest frequency words first
        return result;
    }

    // Sort Characters by Frequency
    public static String sortCharactersByFrequency(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(frequencyMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return result.toString();
    }

    // Find Most Frequent Element in an Array
    public static int findMostFrequentElement(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // Group People by Age
    public static Map<Integer, List<String>> groupPeopleByAge(List<Map.Entry<String, Integer>> people) {
        Map<Integer, List<String>> groupedByAge = new HashMap<>();
        for (Map.Entry<String, Integer> person : people) {
            groupedByAge.computeIfAbsent(person.getValue(), k -> new ArrayList<>()).add(person.getKey());
        }
        return groupedByAge;
    }

    // Find All Pairs with a Given Sum
    public static List<int[]> findPairsWithSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(target - num)) {
                result.add(new int[]{target - num, num});
            }
            map.put(num, 1);
        }
        return result;
    }

    // Sort elements based on their frequency
    public static List<Integer> sortByFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        entryList.sort((entry1, entry2) -> {
            int freqCompare = entry2.getValue().compareTo(entry1.getValue());
            int valueCompare = entry1.getKey().compareTo(entry2.getKey());
            return freqCompare == 0 ? valueCompare : freqCompare;
        });

        List<Integer> sortedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sortedList.addAll(Collections.nCopies(entry.getValue(), entry.getKey()));
        }
        return sortedList;
    }

    // First Unique Character in a String
    public static int firstUniqueChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // Check for Subarray with Zero Sum
    public static boolean hasZeroSumSubarray(int[] nums) {
        Set<Integer> sumSet = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum == 0 || sumSet.contains(sum)) {
                return true;
            }
            sumSet.add(sum);
        }
        return false;
    }

    // Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    // Find the character with the maximum count in a string
    public static char findMaxRepeatedCharacter(String str) {
        Map<Character, Long> charCounts = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return charCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse('\0');
    }

    // Find all words with the maximum frequency in a sentence
    public static List<String> findAllMaxFrequencyWords(String sentence) {
        Map<String, Long> wordCounts = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        long maxFrequency = Collections.max(wordCounts.values());

        return wordCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}