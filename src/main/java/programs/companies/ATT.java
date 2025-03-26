package programs.companies;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ATT {
    // Method to filter students with <40 marks in Maths
    public static List<String> getStudentsWithLowMathScores(List<Student> students) {
        return students.stream()
                .filter(s -> s.marks().maths() < 40) // Filter students with Maths < 40
                .map(Student::name)                    // Get the name of the student
                .toList();
    }

    // Method to count occurrences of a specific character in a list of strings
    public static long countCharacter(List<String> list, char targetChar) {
        return list.stream()
                .flatMapToInt(String::chars)            // Convert each string to IntStream of characters
                .mapToObj(ch -> (char) ch)           // Convert each int to a character
                .filter(ch -> ch == targetChar)// Filter matching characters
                .count();                               // Count occurrences
    }

    // Method to calculate the frequency of all characters in a list of strings
    public static Map<Character, Long> getCharacterFrequency(List<String> list) {
        return list.stream()
                .flatMapToInt(String::chars)          // Convert each string to IntStream of characters
                .mapToObj(ch -> (char) ch)         // Convert each int to a character
                .collect(Collectors.groupingBy(       // Group by each character
                        Function.identity(),          // Use character itself as the key
                        Collectors.counting()         // Count occurrences
                ));
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("abc", 123, new Marks(50, 32, 80)),
                new Student("xyz", 124, new Marks(50, 60, 80))
        );

        List<String> names = Arrays.asList("Niteen", "Durga", "Rahul");

        // 1. Get students with Maths < 40
        List<String> lowMathScores = getStudentsWithLowMathScores(students);
        System.out.println("Students with Maths < 40: " + lowMathScores);

        // 2. Count occurrences of 'a'
        long countA = countCharacter(names, 'a');
        System.out.println("Count of 'a': " + countA);

        // 3. Frequency of all characters
        Map<Character, Long> freq = getCharacterFrequency(names);
        System.out.println("Character Frequency: " + freq);
    }
}

record Student(String name, int rollNo, Marks marks) {
}

record Marks(int english, int maths, int history) {
}