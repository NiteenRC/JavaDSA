package dsa;

public class MissingNumber {
    public static int findMissing(int[] nums) {
        int n = nums.length + 1; // Number of elements including the missing one
        int totalSum = n * (n + 1) / 2; // Sum of first n natural numbers

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return totalSum - sum; // Missing element
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 2, 8, 4, 6}; // Example unsorted list
        int missing = findMissing(nums);
        System.out.println("The missing element is: " + missing);
    }
}