package april;

import java.util.*;

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
