package programs.dsa;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum SubArray Sum: " + maxSubArraySum(nums)); // Output: 6
    }



    // brute force
    private static int maxSubArraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize to the smallest possible value

        // Iterate through all possible starting points of subarrays
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0; // Initialize the sum for the subarray starting at 'i'
            // Iterate through all possible ending points for the subarray starting at 'i'
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j]; // Add the current element to the running sum
                maxSum = Math.max(maxSum, currentSum); // Update maxSum if currentSum is larger
            }
        }
        return maxSum;
    }
}
