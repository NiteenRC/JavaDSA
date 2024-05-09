package programs.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * int [] arr = {1,2,3,4,6}
 * int k = 3 then sub arrays will be {1,2,3}, {2,3,4},{3,4,6}
 * here 3 occurred most of the time in all the windows, so answer = 3
 */
public class MostFrequentElementInSubarrays {
    public static int mostFrequentElement(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int mostFreqElement = arr[0];

        // Initialize frequency map for the first subarray
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        // Update max frequency and most frequent element for the first subarray
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFreqElement = entry.getKey();
            }
        }

        // Slide the window and update frequency map for each subarray
        for (int i = k; i < arr.length; i++) {
            // Remove the leftmost element from the window
            int leftElement = arr[i - k];
            freqMap.put(leftElement, freqMap.get(leftElement) - 1);

            // Add the rightmost element to the window
            int rightElement = arr[i];
            freqMap.put(rightElement, freqMap.getOrDefault(rightElement, 0) + 1);

            // Update max frequency and most frequent element
            if (freqMap.get(rightElement) > maxFreq) {
                maxFreq = freqMap.get(rightElement);
                mostFreqElement = rightElement;
            }
        }

        return mostFreqElement;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int result = mostFrequentElement(arr, k);
        System.out.println("Most frequent element in subarrays of size " + k + ": " + result);
    }
}
