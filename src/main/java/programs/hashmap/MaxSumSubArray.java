package programs.hashmap;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSumSubArray {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0]; // Handle empty input
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Result array to store maximums
        int index = 0; // Index for the result array
        Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices

        for (int i = 0; i < n; i++) {
            // 1. Remove elements out of window range from the front of the deque
            while (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            // 2. Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. Add the current element's index to the deque
            deque.offer(i);

            // 4. Store the maximum element for the current window
            if (i >= k - 1) { // We have a full window of size k
                result[index++] = nums[deque.peek()]; // Get max from front of deque
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
}