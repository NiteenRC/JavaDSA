package programs.companies;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq {
    public static void main(String[] args) {
        String s = "No, I don’t dare. Poor boy, I reckon he’s lied about it—but it’s a blessed, blessed lie, there’s such a comfort come from it. I hope the Lord—I know the Lord will forgive him, because it was such good-heartedness in him to tell it. But I don’t want to find out it’s a lie. I won’t look. She put the jacket away, and stood by musing a minute. Twice she put out her hand to take the garment again, and twice she refrained. Once more she ventured, and this time she fortified herself with the thought";

        String cleaned = s.replaceAll("[^\\w\\s’]", ""); // keep letters, digits, spaces, and apostrophes
        String[] arr = cleaned.split("\\s+");

        Map<String, Long> map = Arrays.stream(arr)
                .filter(word -> !word.isEmpty() && Character.isUpperCase(word.charAt(0)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
