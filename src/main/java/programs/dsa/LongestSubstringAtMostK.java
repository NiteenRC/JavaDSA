package programs.dsa;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostK {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

    public static int longestSubstring(String s, int k) {
        int n = s.length();

        if (n == 0 || k > n)
            return 0;
        if (k == 1)
            return n;

        // Count the frequency of each character
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charFrequencyMap.put(s.charAt(i), charFrequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Find the first character that doesn't meet the k requirement
        int left = 0;
        while (left < n && charFrequencyMap.get(s.charAt(left)) >= k)
            left++;

        // If the whole string meets the k requirement, return its length
        if (left >= n - 1)
            return left;

        // Recursively find the longest substring on the left and right of the invalid
        // character
        int leftSubstringLength = longestSubstring(s.substring(0, left), k);
        while (left < n && charFrequencyMap.get(s.charAt(left)) < k)
            left++;
        int rightSubstringLength = longestSubstring(s.substring(left), k);

        // Return the maximum length of the two substrings
        return Math.max(leftSubstringLength, rightSubstringLength);
    }
}
