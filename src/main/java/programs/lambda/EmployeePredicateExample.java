package programs.lambda;

import programs.sort.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EmployeePredicateExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Smith", "Female"),
                new Employee("Bob", "Jones", "Male"),
                new Employee("Charlie", "Brown", "Male"),
                new Employee("David", 120000),
                new Employee("Eve", 95000)
        );

        Predicate<Employee> isMale = e -> "Male".equals(e.getGender());
        Predicate<Employee> hasHighSalary = e -> e.getSalary() > 100000;
        Predicate<Employee> nameStartsWithA = e -> e.getFirstName().startsWith("A");

        // Using 'and' method
        Predicate<Employee> isMaleAndHasHighSalary = isMale.and(hasHighSalary);

        // Using 'or' method
        Predicate<Employee> isMaleOrHasHighSalary = isMale.or(hasHighSalary);

        // Using 'negate' method
        Predicate<Employee> isNotMale = isMale.negate();

        // Using 'not' method (introduced in Java 11)
        Predicate<Employee> isNotNameStartsWithA = Predicate.not(nameStartsWithA);

        System.out.println("Male employees:");
        employees.stream().filter(isMale).forEach(System.out::println);

        System.out.println("\nEmployees with high salary:");
        employees.stream().filter(hasHighSalary).forEach(System.out::println);

        System.out.println("\nMale employees with high salary:");
        employees.stream().filter(isMaleAndHasHighSalary).forEach(System.out::println);

        System.out.println("\nMale employees or employees with high salary:");
        employees.stream().filter(isMaleOrHasHighSalary).forEach(System.out::println);

        System.out.println("\nEmployees who are not male:");
        employees.stream().filter(isNotMale).forEach(System.out::println);

        System.out.println("\nEmployees whose names do not start with 'A':");
        employees.stream().filter(isNotNameStartsWithA).forEach(System.out::println);
    }
}