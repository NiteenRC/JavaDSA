package interview.sum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List<Integer> list = Arrays.asList(3, 1, 2, 4, 5, 6, 7, 8, 9, -1);
 * int targetSum = 8;
 * <p>
 * output = [[1, 7], [2, 6], [3, 5], [9, -1]]
 */
public class TwoSumPairs1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 4, 5, 6, 7, 8, 9, -1);
        int targetSum = 8;

        List<List<Integer>> result = java8(list, targetSum);
        System.out.println(result);
    }

    private static List<List<Integer>> java7(List<Integer> nums, int targetSum) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int currentNum = nums.get(i);
            int complement = targetSum - currentNum;

            if (numToIndexMap.containsKey(complement)) {
                result.add(Arrays.asList(complement, currentNum));
            }
            numToIndexMap.put(currentNum, i);
        }

        // Sort the result based on the first element of each pair
        result.sort(Comparator.comparingInt(pair -> pair.get(0)));
        return result;
    }

    private static List<List<Integer>> java8(List<Integer> nums, int targetSum) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        return nums.stream()
                .filter(num -> {
                    int complement = targetSum - num;
                    if (numToIndexMap.containsKey(complement)) {
                        return true;
                    } else {
                        numToIndexMap.put(num, num);
                        return false;
                    }
                })
                .map(num -> {
                    int complement = targetSum - num;
                    return Arrays.asList(complement, num);
                })
                .sorted(Comparator.comparingInt(pair -> pair.get(0)))
                .collect(Collectors.toList());
    }
}
