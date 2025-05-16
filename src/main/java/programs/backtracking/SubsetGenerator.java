package programs.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {
    public static void generateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // Exclude current element
        generateSubsets(nums, index + 1, subset, result);
        // Include current element
        subset.add(nums[index]);
        generateSubsets(nums, index + 1, subset, result);
        subset.removeLast(); // Backtrack
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        System.out.println(result);
    }
}
