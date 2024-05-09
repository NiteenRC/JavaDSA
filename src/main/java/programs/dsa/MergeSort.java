package programs.dsa;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 10};
        int[] nums2 = {3, 7, 11, 12, 45};

        int[] nums = mergeSortedArrays(nums1, nums2);

        System.out.println(Arrays.toString(nums));
    }

    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int index = 0;
        int[] nums = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[index++] = nums1[i++];
            } else {
                nums[index++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            nums[index++] = nums1[i++];
        }

        while (j < nums2.length) {
            nums[index++] = nums2[j++];
        }

        return nums;
    }
}
