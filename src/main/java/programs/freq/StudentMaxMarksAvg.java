package programs.freq;

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

public class StudentMaxMarksAvg {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Bob", 80),
                new Student("Dane", 1),
                new Student("Bob", 80),
                new Student("Dane", 2),
                new Student("Dane", 3),
                new Student("Alice", 10));

        double maxAverage = calculateMaxAverageUsingJava7(students);
        System.out.println(maxAverage);
    }

    private static double calculateMaxAverageUsingJava8(List<Student> students) {
        Map<String, List<Integer>> studentMarksMap = new HashMap<>();

        for (Student student : students) {
            studentMarksMap.computeIfAbsent(student.getName(), k -> new ArrayList<>()).add(student.getMark());
        }

        double maxAverage = Double.NEGATIVE_INFINITY;

        for (List<Integer> marksList : studentMarksMap.values()) {
            double average = marksList.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    private static double calculateMaxAverageUsingJava7(List<Student> students) {
        Map<String, List<Integer>> studentMarksMap = new HashMap<>();

        // Populate studentMarksMap with student names as keys and their marks as values
        for (Student student : students) {
            String name = student.getName();
            int mark = student.getMark();
            List<Integer> marksList = studentMarksMap.get(name);
            if (marksList == null) {
                marksList = new ArrayList<>();
                studentMarksMap.put(name, marksList);
            }
            marksList.add(mark);
        }

        double maxAverage = Double.NEGATIVE_INFINITY;

        // Iterate over each student's marks to calculate the average
        for (List<Integer> marksList : studentMarksMap.values()) {
            int totalMarks = 0;
            for (int mark : marksList) {
                totalMarks += mark;
            }
            double average = (double) totalMarks / marksList.size();
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }
}

class Student {
    private String name;
    private int mark;

    Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
