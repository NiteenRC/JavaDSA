package programs.companies;

import java.util.ArrayList;
import java.util.List;

public class OneTwoComposition {

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> result = new ArrayList<>();
        generateCompositions(n, new ArrayList<>(), result);

        System.out.println("Compositions using only 1 and 2 that sum to " + n + ":");
        for (List<Integer> composition : result) {
            System.out.println(composition);
        }
    }

    private static void generateCompositions(int n, List<Integer> current, List<List<Integer>> result) {
        if (n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try only 1 and 2 (if they don't exceed n)
        for (int i = 1; i <= Math.min(n, 2); i++) {
            current.add(i);
            generateCompositions(n - i, current, result);
            current.removeLast(); // backtrack
        }
    }
}