package programs.companies;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumIndices {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 1, 8, 6, 7};
        int target = 7;

        List<List<Integer>> result = findTargetIndexCombinations(nums, target);

        for (List<Integer> combination : result) {
            System.out.println("Indices: " + combination);
        }
    }

    public static List<List<Integer>> findTargetIndexCombinations(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private static void backtrack(int[] nums, int target, int start, List<Integer> current, int currentSum, List<List<Integer>> result) {
        if (currentSum == target && !current.isEmpty()) {
            result.add(new ArrayList<>(current));
            return; // If you want all possibilities including supersets, remove this `return`.
        }

        for (int i = start; i < nums.length; i++) {
            if (currentSum + nums[i] > target) continue;

            current.add(i); // add index
            backtrack(nums, target, i + 1, current, currentSum + nums[i], result);
            current.removeLast(); // backtrack
        }
    }
}
