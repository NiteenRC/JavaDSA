package programs.inteview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxAvgMarks {
    public static void main(String[] args) {
        MaxAvgMarks solution = new MaxAvgMarks();
        ScoreRecord[] scores = {
                new ScoreRecord("bobby", 20),
                new ScoreRecord("arun", 30),
                new ScoreRecord("bobby", 60)
        };

        int result = solution.maxAverageMarks(scores);
        System.out.println("Maximum Average Marks (floored): " + result); // Output: 40
    }

    public int maxAverageMarks(ScoreRecord[] scores) {
        // Group scores by student name and calculate average marks using Stream API
        Map<String, Double> studentAverages = Arrays.stream(scores)
                .collect(Collectors.groupingBy(ScoreRecord::name,
                        Collectors.averagingInt(ScoreRecord::score)));

        // Compute the maximum average score
        return studentAverages.values().stream()
                .mapToInt(Double::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}

// Custom record to represent student scores
record ScoreRecord(String name, int score) {
}