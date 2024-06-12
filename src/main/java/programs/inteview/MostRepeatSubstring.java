package programs.inteview;

public class MostRepeatSubstring {
    public static void main(String[] args) {
        MostRepeatSubstring solution = new MostRepeatSubstring();
        String input = "aabbbbcccbb";

        int[] result = solution.maxContiguousRepeatingChar(input);
        System.out.println("Starting Index: " + result[0] + ", Length: " + result[1]); // Output: [2, 4]
    }

    public int[] maxContiguousRepeatingChar(String s) {
        if (s == null || s.isEmpty()) {
            return new int[]{-1, 0}; // Handle empty string case
        }

        char[] chars = s.toCharArray();
        int maxStartIndex = 0;
        int maxLength = 1;
        int currentStartIndex = 0;
        int currentLength = 1;

        // Iterate over the characters to find the maximum contiguous repeating substring
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == chars[i - 1]) {
                currentLength++;
            } else {
                // Update maximum length and start index if the current sequence is longer
                if (currentLength > maxLength) {
                    maxStartIndex = currentStartIndex;
                    maxLength = currentLength;
                }
                currentStartIndex = i;
                currentLength = 1;
            }
        }

        // Final check in case the longest sequence is at the end of the string
        if (currentLength > maxLength) {
            maxStartIndex = currentStartIndex;
            maxLength = currentLength;
        }

        return new int[]{maxStartIndex, maxLength};
    }
}