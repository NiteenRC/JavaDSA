package programs.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Find the nth highest salary of Employees
 * int n = 5
 */
public class FindNthHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Harish", 100),
                new Employee("Ajay", 600),
                new Employee("Kiran", 300),
                new Employee("Tarun", 700),
                new Employee("Evan", 800)
        );

        Employee employee = findNthHighestSalary(employees);
        System.out.println(employee.firstName() + " " + employee.salary());
    }

    private static Employee findNthHighestSalary(List<Employee> employees) {
        List<Employee> sorted = employees.stream()
                .sorted((e1, e2) -> e2.salary() - e1.salary())
                .toList();

        Optional<Employee> employee = sorted.stream().skip(2 - 1).findFirst();

        return employee.orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
