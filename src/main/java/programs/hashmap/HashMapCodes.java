package programs.hashmap;

import java.util.*;

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

        // 4. Find Duplicate Numbers in an Array
        System.out.println("\n4. Find Duplicate Numbers in an Array");
        List<Integer> duplicates = findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(duplicates);

        // 5. Count Vowels and Consonants in a String
        System.out.println("\n5. Count Vowels and Consonants in a String");
        Map<String, Integer> vowelConsonantCount = countVowelsAndConsonants("hello world");
        System.out.println(vowelConsonantCount);

        // 6. Longest Substring Without Repeating Characters
        System.out.println("\n6. Longest Substring Without Repeating Characters");
        int longestSubstringLength = lengthOfLongestSubstring("abcabcbb");
        System.out.println(longestSubstringLength);

        // 7. Find Most Frequent Element in an Array
        System.out.println("\n7. Find Most Frequent Element in an Array");
        int mostFrequentElement = findMostFrequentElement(new int[]{1, 3, 2, 3, 1, 3, 4, 1});
        System.out.println(mostFrequentElement);

        // 8. Group People by Age
        System.out.println("\n8. Group People by Age");
        Map<Integer, List<String>> groupedByAge = groupPeopleByAge(Arrays.asList(
                new AbstractMap.SimpleEntry<>("Alice", 25),
                new AbstractMap.SimpleEntry<>("Bob", 30),
                new AbstractMap.SimpleEntry<>("Charlie", 25),
                new AbstractMap.SimpleEntry<>("David", 30),
                new AbstractMap.SimpleEntry<>("Eve", 35)));
        System.out.println(groupedByAge);

        // 9. Find All Pairs with a Given Sum
        System.out.println("\n9. Find All Pairs with a Given Sum");
        List<int[]> pairs = findPairsWithSum(new int[]{1, 2, 3, 4, 5}, 6);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        // 10. Character Frequency in a String
        System.out.println("\n10. Character Frequency in a String");
        Map<Character, Integer> charFrequency = characterFrequency("abracadabra");
        System.out.println(charFrequency);
    }

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

    public static List<String> topKFrequentWords(List<String> words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String num : words) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
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
        return result;
    }


    public static String sortCharactersByFrequency(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        heap.addAll(frequencyMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            sb.append(String.valueOf(c).repeat(frequencyMap.get(c)));
        }
        return sb.toString();
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int num : nums) {
            if (!seen.add(num)) duplicates.add(num);
        }
        return duplicates;
    }

    public static Map<String, Integer> countVowelsAndConsonants(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int vowelCount = 0, consonantCount = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.contains(c)) vowelCount++;
                else consonantCount++;
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("Vowels", vowelCount);
        result.put("Consonants", consonantCount);
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left++));
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int findMostFrequentElement(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static Map<Integer, List<String>> groupPeopleByAge(List<Map.Entry<String, Integer>> people) {
        Map<Integer, List<String>> groupedByAge = new HashMap<>();
        for (Map.Entry<String, Integer> person : people) {
            groupedByAge.computeIfAbsent(person.getValue(), k -> new ArrayList<>()).add(person.getKey());
        }
        return groupedByAge;
    }

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

    public static Map<Character, Integer> characterFrequency(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}

