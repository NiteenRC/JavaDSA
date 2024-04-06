package april;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSumPairs2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 6, 8};
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
                .mapToObj(i -> Arrays.asList(map.get(target - nums[i]), i))
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> java7(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                result.add(Arrays.asList(map.get(diff), i));
            }
            map.put(num, i);
        }
        return result;
    }
}