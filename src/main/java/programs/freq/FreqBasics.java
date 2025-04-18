package programs.freq;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FreqBasics {
    public static void main(String[] args) {
        String s = "programme";

        System.out.println("== Basic Grouping ==");
        System.out.println(freq(s)); // Expected: {p=[p], r=[r, r], o=[o], g=[g], a=[a], m=[m, m], e=[e]}

        System.out.println("\n== Insertion Order Frequency ==");
        System.out.println(preserveInsertionOrder(s)); // Expected: {p=1, r=2, o=1, g=1, a=1, m=2, e=1}

        System.out.println("\n== Sorted by Character Keys ==");
        System.out.println(sortByKeys(s)); // Expected: {a=[a], e=[e], g=[g], m=[m, m], o=[o], p=[p], r=[r, r]}

        System.out.println("\n== Sorted by Frequency Ascending ==");
        System.out.println(sortByFreq(s)); // Expected: {p=1, o=1, g=1, a=1, e=1, r=2, m=2}

        System.out.println("\n== Sorted by Frequency Descending ==");
        System.out.println(sortByFreqDesc(s)); // Expected: {r=2, m=2, p=1, o=1, g=1, a=1, e=1}

        System.out.println("\n== Most Frequent Character(s) ==");
        System.out.println(mostFrequentChar(s)); // Expected: Most Frequent Char(s): [r, m] -> Frequency: 2

        System.out.println("\n== Least Frequent Character(s) ==");
        System.out.println(leastFrequentChar(s)); // Expected: Least Frequent Char(s): [p, o, g, a, e] -> Frequency: 1

        System.out.println("\n== 3rd Most Frequent Character(s) ==");
        System.out.println(thirdMostFrequentChar(s)); // Expected: Only 2 distinct frequencies found. No 3rd most frequent character.

        System.out.println("\n== Nth Most Frequent Character(s) ==");
        System.out.println(nthMostFrequentChar(s, 2)); // Expected: Nth Most Frequent Char(s): [p, o, g, a, e] -> Frequency: 1

        System.out.println("\n== Grouped by Frequency ==");
        System.out.println(groupByFrequency(s)); // Expected: {1=[p, o, g, a, e], 2=[r, m]}

        System.out.println("\n== Most Frequent Using PriorityQueue ==");
        System.out.println(mostFrequentUsingPQ(s)); // Expected: Most Frequent using PQ: r -> 2

        System.out.println("\n== Frequency Comparison Between Two Strings ==");
        System.out.println("Are frequencies same? " + areFrequenciesEqual("abcabc", "bcaacb")); // Expected: true
    }

    private static Map<Character, List<Character>> freq(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity()));
    }

    private static Map<Character, Long> preserveInsertionOrder(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
    }

    private static Map<Character, List<Character>> sortByKeys(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.toList()
                ));
    }

    private static Map<Character, Long> sortByFreq(String s) {
        Map<Character, Long> frequencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private static Map<Character, Long> sortByFreqDesc(String s) {
        Map<Character, Long> frequencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    private static String mostFrequentChar(String s) {
        Map<Character, Long> freq = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long max = freq.values().stream().max(Long::compareTo).orElse(0L);

        List<Character> mostFrequent = freq.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .toList();

        return "Most Frequent Char(s): " + mostFrequent + " -> Frequency: " + max;
    }

    private static String leastFrequentChar(String s) {
        Map<Character, Long> freq = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long min = freq.values().stream().min(Long::compareTo).orElse(0L);

        List<Character> leastFrequent = freq.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == min)
                .map(Map.Entry::getKey)
                .toList();

        return "Least Frequent Char(s): " + leastFrequent + " -> Frequency: " + min;
    }

    private static String thirdMostFrequentChar(String s) {
        return nthMostFrequentChar(s, 3);
    }

    private static String nthMostFrequentChar(String s, int n) {
        Map<Character, Long> freqMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Long> sortedFreqs = freqMap.values().stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        if (n > sortedFreqs.size()) {
            return "Only " + sortedFreqs.size() + " distinct frequencies found. No " + n + "th most frequent character.";
        }

        long targetFreq = sortedFreqs.get(n - 1);

        List<Character> result = freqMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == targetFreq)
                .map(Map.Entry::getKey)
                .toList();

        return n + "th Most Frequent Char(s): " + result + " -> Frequency: " + targetFreq;
    }

    private static Map<Long, List<Character>> groupByFrequency(String s) {
        Map<Character, Long> freqMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return freqMap.entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        TreeMap::new,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ));
    }

    private static String mostFrequentUsingPQ(String s) {
        Map<Character, Long> freqMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        PriorityQueue<Map.Entry<Character, Long>> maxHeap =
                new PriorityQueue<>((a, b) -> Long.compare(b.getValue(), a.getValue()));

        maxHeap.addAll(freqMap.entrySet());

        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Long> top = maxHeap.poll();
            return "Most Frequent using PQ: " + top.getKey() + " -> " + top.getValue();
        }

        return "No characters found";
    }

    private static boolean areFrequenciesEqual(String s1, String s2) {
        Map<Character, Long> freq1 = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> freq2 = s2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return freq1.equals(freq2);
    }
}