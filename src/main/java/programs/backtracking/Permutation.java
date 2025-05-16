package programs.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String s = "ABC";
        //Output: "ABC", "ACB", "BAC", "BCA", "CAB", "CBA";

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        backTrack(s, new StringBuilder(), used, result);
        System.out.println(result);
    }

    private static void backTrack(String s, StringBuilder current, boolean[] used, List<String> result) {
        if (current.length() == 3) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            current.append(s.charAt(i));
            backTrack(s, current, used, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
