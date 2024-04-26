package interview.dsa;

/**
 * Search in Rotated Sorted Array
 * <p>
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1223265018/
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 6, 9, 10, 2, 3};
        int k = 2;

        System.out.println(searchInRotatedSortedArray(nums, k));
    }

    private static int searchInRotatedSortedArray(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == k) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= k && nums[mid] >= k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= k && nums[right] >= k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
