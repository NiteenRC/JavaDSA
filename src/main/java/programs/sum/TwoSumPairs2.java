package programs.sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Find the two sum equals to target given and output should be index of sum
 * target = 9
 * output = [[0,1], [4,6]]
 */
public class TwoSumPairs2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 8, 6};
        int target = 9;
        List<List<Integer>> pairs = java8(nums, target);
        pairs.forEach(System.out::println);
    }

    public static List<List<Integer>> java8(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return IntStream.range(0, nums.length)
                .filter(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return true;
                    }
                    map.put(nums[i], i);
                    return false;
                })
                .mapToObj(i -> List.of(map.get(target - nums[i]), i))
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> java7(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.add(List.of(map.get(complement), i));
            }
            map.put(nums[i], i);
        }
        return result;
    }
}