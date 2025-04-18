package programs.companies;

import java.util.stream.IntStream;

public class Zensar {
    public static void main(String[] args) {
        String s1 = "India";
        String s2 = "1234567";
        //Output: I1n2d3i4a567

        StringBuilder result = getStringBuilder(s1, s2);
        System.out.println("Output: " + result);
    }

    private static StringBuilder getStringBuilder(String s1, String s2) {
        int maxLen = Math.max(s1.length(), s2.length());

        StringBuilder result = new StringBuilder();

        IntStream.range(0, maxLen).forEach(i -> {
            if (i < s1.length()) result.append(s1.charAt(i));
            if (i < s2.length()) result.append(s2.charAt(i));
        });
        return result;
    }
}