package programs.freq;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write the below program using java8?
 * Sort the characters by their frequency in descending order?
 * input= “JavaJ2EEE”
 * output=”E3J2a2v121”
 * https://leetcode.com/problems/sort-characters-by-frequency/submissions/1217971453/
 */
public class SortCharsByFreq {
    public static void main(String[] args) {
        String input = "JavaJ2EEE";
        System.out.println(sortByFreq(input));
    }

    private static String sortByFreq(String input) {
        Map<Character, Long> map = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Stream<String> list = map.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .map(entry -> entry.getKey() + "" + entry.getValue());

        return list.collect(Collectors.joining());

    }
}
