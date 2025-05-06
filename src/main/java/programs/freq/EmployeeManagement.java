package programs.freq;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Interview Question:
 * Given a list of employees, implement the following functionalities using Java Streams:
 * <p>
 * 1. Select all employees from the NCR region.
 * 2. Select all employees from the IT department.
 * 3. Map all employees with their ID, ensuring there are no duplicate IDs.
 * <p>
 * You should provide implementations for each task and print the results.
 * Consider edge cases such as employees belonging to multiple departments or regions.
 */

public class EmployeeManagement {
    public static void main(String[] args) {
        Department itDepartment = new Department("IT", "Information Technology");
        Employee employee1 = new Employee("John", itDepartment, "NCR", 1);
        Employee employee2 = new Employee("Alice", itDepartment, "DEL", 2);
        Employee employee3 = new Employee("Bob", itDepartment, "NCR", 3);
        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3);

        // Select all employees from NCR region
        List<Employee> ncrRegionList = employeeList.stream()
                .filter(employee -> employee.getRegion().equals("NCR"))
                .toList();
        System.out.println("Employees from NCR region: " + ncrRegionList);

        // Select all employees from IT department
        List<Employee> itDepartmentList = employeeList.stream()
                .filter(employee -> employee.getDepartment().getName().equals("IT"))
                .toList();
        System.out.println("Employees from IT department: " + itDepartmentList);

        // Map all employees with their ID
        Map<Integer, List<Employee>> mappingEmployeeId = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getId));
        System.out.println("Employees mapped by ID: " + mappingEmployeeId);
    }
}

class Department {
    private final String name;
    private final String description;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

class Employee {
    private final String name;
    private final Department department;
    private final String region;
    private final int id;

    public Employee(String name, Department department, String region, int id) {
        this.name = name;
        this.department = department;
        this.region = region;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public String getRegion() {
        return region;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department=" + department.getName() +
                ", region='" + region + '\'' +
                ", id=" + id +
                '}';
    }
}