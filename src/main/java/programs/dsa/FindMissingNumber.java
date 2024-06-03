package programs.dsa;

public class FindMissingNumber {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i] ^ (i + 1);
        }
        return xor ^ (n + 1); // XOR with the last index
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 5}; // Example input with duplicates
        int missingNumber = findMissingNumber(nums);
        System.out.println("Missing number: " + missingNumber);
    }
}