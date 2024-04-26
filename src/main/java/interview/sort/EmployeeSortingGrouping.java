package interview.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sort by names from given objects? Sort by firstName, lastName and groupBy gender?
 */

public class EmployeeSortingGrouping {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe", "Male"),
                new Employee("Alice", "Smith", "Female"),
                new Employee("David", "Jones", "Male"),
                new Employee("Emma", "Brown", "Female"),
                new Employee("Michael", "Johnson", "Male"),
                new Employee("Sophia", "Williams", "Female")
        );

        // Sort by firstName and then by lastName
        employees.sort(Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName));

        // Print results
        System.out.println("Sorted by firstName, lastName:");
        employees.forEach(System.out::println);

        // Group by gender
        Map<String, List<Employee>> groupedByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        System.out.println("\nGrouped by gender:");
        groupedByGender.forEach((gender, employeeList) -> {
            System.out.println(gender + ":");
            employeeList.forEach(e -> System.out.println(e.getFirstName() + " - " + e.getGender()));
        });
    }
}
