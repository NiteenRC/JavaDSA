package programs.freq;

import java.util.List;
import java.util.stream.Collectors;

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