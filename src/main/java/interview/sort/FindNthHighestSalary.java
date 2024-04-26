package current;

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
                new Employee("A", 100),
                new Employee("B", 600),
                new Employee("C", 300),
                new Employee("D", 700),
                new Employee("E", 800)
        );

        System.out.println(findNthHighestSalary(employees, 100));
    }

    private static Employee findNthHighestSalary(List<Employee> employees, int num) {
        List<Employee> sorted = employees.stream()
                .sorted((e1, e2) -> e2.getSalary() - e1.getSalary())
                .collect(Collectors.toList());

        Optional<Employee> employee = sorted.stream().skip(num - 1).findFirst();

        return employee.orElseThrow(() -> new RuntimeException("Not Found"));
    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
