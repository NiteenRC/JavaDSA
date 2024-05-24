package programs.dsa.dp.one;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet", "code");
        String s = "leetcode";
        System.out.println(wordBreak(s, wordDict)); // should return true

        wordDict = Arrays.asList("apple", "pen");
        s = "applepenapple";
        System.out.println(wordBreak(s, wordDict)); // should return true

        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        s = "catsandog";
        System.out.println(wordBreak(s, wordDict)); // should return false
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Initial state: an empty string can always be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(i + " " + j + " + dp[j] +  " + wordDict.contains(s.substring(j, i)));
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            System.out.println();
        }
        return dp[n];
    }

    private class Solution {

    }
}
