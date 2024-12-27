package programs.dsa;

import java.util.Arrays;

/**
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1, n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);// Initialize result array with 1s

        for (int i = 0; i < n; i++) {
            result[i] *= left;
            left *= nums[i];

            result[n - i - 1] *= right;
            right *= nums[n - i - 1];
        }
        return result;
    }
}
