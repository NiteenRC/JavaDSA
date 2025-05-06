package programs.freq;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interview Question:
 * Implement a method using Java 8 Streams that calculates the highest average marks obtained by any student.
 * <p>
 * Given a list of students with their names and marks, your task is to:
 * 1. Group the students by their names.
 * 2. Calculate the average marks for each group.
 * 3. Return the highest average marks among all students.
 * <p>
 * Example:
 * Input: List of students with names and marks:
 * [("Bob", 80), ("Dane", 1), ("Bob", 80), ("Dane", 2), ("Dane", 3), ("Alice", 10)]
 * Output: 80.0 (Bob has the highest average marks)
 * <p>
 * Consider edge cases such as an empty list of students or students with the same average marks.
 */

public class StudentMaxMarksAvg {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Bob", 80),
                new Student("Dane", 1),
                new Student("Bob", 80),
                new Student("Dane", 2),
                new Student("Dane", 3),
                new Student("Alice", 10));

        double maxAverage = calculateMaxAverageUsingJava8(students);
        System.out.println(maxAverage);
    }

    private static double calculateMaxAverageUsingJava8(List<Student> students) {
        // Group students by name and calculate average marks using Stream API
        return students.stream()
                .collect(Collectors.groupingBy(Student::name, Collectors.averagingInt(Student::mark)))
                .values().stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(Double.NEGATIVE_INFINITY);
    }
}

// Student record for concise representation
record Student(String name, int mark) {
}