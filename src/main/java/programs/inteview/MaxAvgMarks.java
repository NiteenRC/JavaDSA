package programs.inteview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Asked by Goldman Sachs
 */
public class MaxAvgMarks {
    public static void main(String[] args) {
        MaxAvgMarks solution = new MaxAvgMarks();
        String[][] scores = {{"bobby", "20"}, {"arun", "30"}, {"bobby", "60"}};

        int result = solution.maxAverageMarks(scores);
        System.out.println("Maximum Average Marks (floored): " + result); // Output: 40
    }

    public int maxAverageMarks(String[][] scores) {
        Map<String, List<Integer>> studentScores = new HashMap<>();

        // Collect scores for each student
        for (String[] entry : scores) {
            String name = entry[0];
            int score = Integer.parseInt(entry[1]);

            if (!studentScores.containsKey(name)) {
                studentScores.put(name, new ArrayList<>());
            }
            studentScores.get(name).add(score);
        }

        // Compute the maximum average score
        int maxAverage = Integer.MIN_VALUE;

        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            List<Integer> marks = entry.getValue();
            int sum = 0;
            for (int mark : marks) {
                sum += mark;
            }
            int average = sum / marks.size(); // Taking floor value by integer division
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }
}