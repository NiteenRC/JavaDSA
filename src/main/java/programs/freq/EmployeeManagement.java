package programs.freq;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * select all employees from ncr region
 * <p>
 * then select all employees from IT department
 * <p>
 * map all employees with their id
 */

public class EmployeeManagement {
    public static void main(String[] args) {
        Department itDepartment = new Department("IT", "Information Technology");
        Employee employee1 = new Employee("John", itDepartment, "NCR", 1);
        Employee employee2 = new Employee("Alice", itDepartment, "DEL", 2);
        Employee employee3 = new Employee("Alice", itDepartment, "DEL", 2);
        List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3);

        List<Employee> ncrRegionList = employeeList.stream()
                .filter(employee -> employee.getRegion().equals("NCR"))
                .collect(Collectors.toList());

        List<Employee> itDepartmentList = employeeList.stream()
                .filter(employee -> employee.getDepartment().getName().equals("IT"))
                .collect(Collectors.toList());

        Map<Integer, List<Employee>> mappingEmployeeId = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getId));

        System.out.println(mappingEmployeeId);

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
                '}';
    }
}