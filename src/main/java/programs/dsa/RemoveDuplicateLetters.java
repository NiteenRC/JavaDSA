package programs.dsa;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        int[] freq = new int[26]; // Count frequency of each character
        boolean[] visited = new boolean[26]; // To check if a character is already added to result
        char[] chars = s.toCharArray();

        // Count frequencies
        for (char c : chars) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            int index = c - 'a';

            // Decrement frequency of the current character
            freq[index]--;

            // If character is already in the stack, skip it
            if (visited[index]) {
                continue;
            }

            // Remove characters from stack if:
            // 1. They are lexicographically greater than the current character
            // 2. They still have occurrences left in the string
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            // Add current character to stack
            stack.push(c);
            visited[index] = true;
        }

        // Build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println("Result: " + removeDuplicateLetters(s)); // Output: "acdb"
    }
}
