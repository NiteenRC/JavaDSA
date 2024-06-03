package programs.dsa;

public class FindMinInSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[left];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            min = Math.min(min, nums[mid]);

            if (nums[left] == nums[right]) {
                right--;
            } else if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}
