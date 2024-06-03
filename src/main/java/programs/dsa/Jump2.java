package programs.dsa;

public class Jump2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4}; // Example input
        System.out.println("Minimum number of jumps to reach the end: " + jump(nums)); // Outputs 2
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0; // If there's only one element, no jump is needed

        int jumps = 0;
        int left = 0;
        int right = 0;

        while (right < n - 1) {
            int farthest = 0;

            // Find the farthest point that can be reached within the current range (left to right)
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Update the range for the next jump
            left = right + 1;
            right = farthest;

            // Increment the number of jumps
            jumps++;
        }

        return jumps;
    }
}
