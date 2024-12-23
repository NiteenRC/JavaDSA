package programs.dsa;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(2));
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string has 2 * n characters, it’s a valid combination
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Try adding an open parenthesis if we haven’t added all open parentheses
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Try adding a close parenthesis if we have more open parentheses than close
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}

