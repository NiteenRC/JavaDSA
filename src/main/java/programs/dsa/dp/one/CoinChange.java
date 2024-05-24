package programs.dsa.dp.one;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Standard case with multiple denominations
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int result1 = solution.method1(coins1, amount1);
        System.out.println(result1); // Expected output: 3 (5+5+1)

        // Test case 2: Case with single denomination equal to amount
        int[] coins2 = {3};
        int amount2 = 3;
        int result2 = solution.method1(coins2, amount2);
        System.out.println(result2); // Expected output: 1 (3)

        // Test case 3: Case with no possible way to make the amount
        int[] coins3 = {2};
        int amount3 = 3;
        int result3 = solution.method1(coins3, amount3);
        System.out.println(result3); // Expected output: -1 (impossible to make 3 with coins of 2)

        // Test case 4: Case with multiple ways to make the amount
        int[] coins4 = {1, 2, 5};
        int amount4 = 7;
        int result4 = solution.method1(coins4, amount4);
        System.out.println(result4); // Expected output: 2 (5+2)

        // Test case 5: Edge case with zero amount
        int[] coins5 = {1, 2, 5};
        int amount5 = 0;
        int result5 = solution.method1(coins5, amount5);
        System.out.println(result5); // Expected output: 0 (no coins needed)

        // Test case 6: Edge case with single coin type larger than amount
        int[] coins6 = {5};
        int amount6 = 3;
        int result6 = solution.method1(coins6, amount6);
        System.out.println(result6); // Expected output: -1 (impossible to make 3 with coins of 5)

        // Test case 7: Large amount with small denominations
        int[] coins7 = {1, 2, 5};
        int amount7 = 100;
        int result7 = solution.method1(coins7, amount7);
        System.out.println(result7); // Expected output: 20 (20 coins of 5)

        // Test case 8: No coins provided
        int[] coins8 = {};
        int amount8 = 10;
        int result8 = solution.method1(coins8, amount8);
        System.out.println(result8); // Expected output: -1 (no coins available to make any amount)

        // Test case 9: Large denominations with large amount
        int[] coins9 = {25, 50, 100};
        int amount9 = 300;
        int result9 = solution.method1(coins9, amount9);
        System.out.println(result9); // Expected output: 3 (3 coins of 100)

        // Test case 10: Multiple denominations including 1
        int[] coins10 = {1, 3, 4};
        int amount10 = 6;
        int result10 = solution.method1(coins10, amount10);
        System.out.println(result10); // Expected output: 2 (3+3 or 4+1+1)

        // Additional edge cases
        // Test case 11: Amount is 1 with coin denominations including 1
        int[] coins11 = {1, 2, 5};
        int amount11 = 1;
        int result11 = solution.method1(coins11, amount11);
        System.out.println(result11); // Expected output: 1 (1)

        // Test case 12: Amount and denominations both large
        int[] coins12 = {186, 419, 83, 408};
        int amount12 = 6249;
        int result12 = solution.method1(coins12, amount12);
        System.out.println(result12); // Expected output: 20 (derived from the specific combination of coins)

        // Test case 13: Minimal input case
        int[] coins13 = {1};
        int amount13 = 1;
        int result13 = solution.method1(coins13, amount13);
        System.out.println(result13); // Expected output: 1 (1)
    }

    static class Solution {
        public int method1(int[] coins, int amount) {
            // Initialize an array to store the minimum number of coins needed for each amount
            int[] dp = new int[amount + 1];

            // Fill the array with a value larger than any possible solution
            Arrays.fill(dp, amount + 1);

            // Base case: No coins needed to make amount 0
            dp[0] = 0;

            // Iterate through each coin denomination
            for (int coin : coins) {
                // For each coin, iterate through each amount from coin value to target amount
                for (int i = coin; i <= amount; i++) {
                    // Calculate the minimum number of coins needed for the current amount
                    // by choosing either the current coin or the best solution for the smaller amount
                    System.out.println("coin:" + coin + " dp[i]:" + dp[i] + " " + " dp[i - coin]:" + dp[i - coin]);
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            // If dp[amount] is still larger than amount, it means no valid combination was found
            // Return -1 in this case, otherwise, return the minimum number of coins needed
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}