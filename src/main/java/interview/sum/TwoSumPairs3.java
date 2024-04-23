package interview.sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * If duplicate record then only add the first character index
 * input = [2, 2, 7, 11, 15]
 * output = [0, 2]
 */
public class TwoSumPairs3 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 7, 11, 15, -6, 3, 6, 8};
        int target = 9;
        List<List<Integer>> pairs = java8(nums, target);
        pairs.forEach(System.out::println);
    }

    public static List<List<Integer>> java7(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int difference = target - num;
            if (numIndexMap.containsKey(difference)) {
                result.add(Arrays.asList(numIndexMap.get(difference), i));
            }

            if (!numIndexMap.containsKey(num)) {
                numIndexMap.put(num, i);
            }
        }
        return result;
    }

    public static List<List<Integer>> java8(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        return IntStream.range(0, nums.length)
                .filter(i -> {
                    int complement = target - nums[i];
                    if (numIndexMap.containsKey(complement)) {
                        return true;
                    }
                    numIndexMap.putIfAbsent(nums[i], i);
                    return false;
                })
                .mapToObj(i -> Arrays.asList(numIndexMap.get(target - nums[i]), i))
                .collect(Collectors.toList());
    }
}
