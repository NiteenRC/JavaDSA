package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMarksSorter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Rama", "Math", 50),
                new Student("Rama", "Physics", 60),
                new Student("Rama", "English", 45),
                new Student("Hari", "Math", 70),
                new Student("Hari", "Physics", 65),
                new Student("Hari", "English", 85),
                new Student("Gita", "Math", 90),
                new Student("Gita", "Physics", 55),
                new Student("Gita", "English", 65));

        Map<String, Integer> studentTotalMarks = students.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getMarks)));

        List<Map.Entry<String, Integer>> sortedStudents = new ArrayList<>(studentTotalMarks.entrySet());

        sortedStudents.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue()); // Sort in descending order

        sortedStudents.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

class Student {
    private String name;
    private String subject;
    private int marks;

    public Student(String name, String subject, int marks) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
