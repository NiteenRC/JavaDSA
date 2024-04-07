package april;

import java.util.*;

/**
 * Given an array of students and their marks in different subjects,
 * find the maximum average of the student in the following format below.
 * <p>
 * Format: `{ name, avg}`
 * <p>
 * For example:
 * { { "Alice", "70"}, { "Bob", "80"}, { "Charles", "75"}, { "Bob", "80"},
 * { "Dane", "1"}, { "Dane", "2"}, { "Dane", "3"} }
 * <p>
 * Average calculation:
 * - For Alice, Bob, Charles, and Dane, the average marks are 70, 80, 75, and 2 respectively.
 * - So, the highest average is 80, which should be returned.
 */
public class StudentMarksAvg {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Bob", 80),
                new Student("Dane", 1),
                new Student("Bob", 80),
                new Student("Dane", 2),
                new Student("Dane", 3),
                new Student("Alice", 10)
        );
        int maxAverage = calculateMaxAverage(students);
        System.out.println(maxAverage);
    }

    private static int calculateMaxAverage(List<Student> students) {
        Map<String, List<Integer>> studentMarksMap = new HashMap<>();

        for (Student student : students) {
            if (studentMarksMap.containsKey(student.name)) {
                studentMarksMap.get(student.name).add(student.marks);
            } else {
                List<Integer> marksList = new ArrayList<>();
                marksList.add(student.marks);
                studentMarksMap.put(student.name, marksList);
            }
        }

        int maxAverage = Integer.MIN_VALUE;

        for (List<Integer> marksList : studentMarksMap.values()) {
            int totalMarks = 0;
            for (int mark : marksList) {
                totalMarks += mark;
            }
            int average = totalMarks / marksList.size();
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }
}

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}
