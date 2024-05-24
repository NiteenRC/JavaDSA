package programs.sliding;

import java.util.Arrays;

public class LongestHomogeneousSubstring {
    public static int[] longestHomogeneousSubstring(String s) {
        char first = s.charAt(0);
        int count = 1; // Initialize count to 1 to account for the first character
        int left = 0;
        int max = 0;
        int[] res = new int[2];

        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == first) {
                count++;
                if (count > max) {
                    max = count;
                    res = new int[]{left, count}; // Update result array
                }
            } else {
                first = s.charAt(right); // Update first character
                left = right; // Update left index to start of next potential homogeneous substring
                count = 1; // Reset count
            }
        }

        // Check if the longest homogeneous substring extends until the end of the string
        if (count > max) {
            res = new int[]{left, count};
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "eaaddaaabbb";
        int[] result = longestHomogeneousSubstring(s);
        System.out.println(Arrays.toString(result));
    }
}
