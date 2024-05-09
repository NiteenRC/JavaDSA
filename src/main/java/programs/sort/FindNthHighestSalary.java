package programs.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Find the nth highest salary of Employees
 * int n = 5
 */
public class FindNthHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Harish", 100),
                new Employee("Ajay", 600),
                new Employee("Kiran", 300),
                new Employee("Tarun", 700),
                new Employee("Evan", 800)
        );

        Employee employee = findNthHighestSalary(employees, 2);
        System.out.println(employee.getFirstName() + " " + employee.getSalary());
    }

    private static Employee findNthHighestSalary(List<Employee> employees, int num) {
        List<Employee> sorted = employees.stream()
                .sorted((e1, e2) -> e2.getSalary() - e1.getSalary())
                .collect(Collectors.toList());

        Optional<Employee> employee = sorted.stream().skip(num - 1).findFirst();

        return employee.orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
