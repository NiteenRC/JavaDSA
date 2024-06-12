package programs.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {
    private static final List<Employee> employeeList = List.of(
            new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0),
            new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0),
            new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0),
            new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0),
            new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0),
            new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0),
            new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0),
            new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0),
            new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0),
            new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5),
            new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0),
            new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0),
            new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 22700.0),
            new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5),
            new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0),
            new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0),
            new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0)
    );

    public static void main(String[] args) {
        countMaleAndFemaleEmployees();
        printAllDepartments();
        printAverageAgeByGender();
        printHighestPaidEmployee();
        printEmployeesJoinedAfter(2015);
        countEmployeesInEachDepartment();
        printAverageSalaryByDepartment();
        printYoungestMaleEmployeeInDepartment("Product Development");
        printMostExperiencedEmployee();
        countMaleAndFemaleEmployeesInDepartment("Sales And Marketing");
        listEmployeeNamesByDepartment();
        printOrganizationSalaryStats();
        separateEmployeesByAge(25);
        printOldestEmployeeDetails();
        printMaxSalaryOfEmployeesForEachAgeGroup();
        printDepartmentGenderSalaryStats();
    }

    private static void countMaleAndFemaleEmployees() {
        var genderCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
        genderCount.forEach((gender, count) -> System.out.println(gender + ": " + count));
    }

    private static void printAllDepartments() {
        employeeList.stream()
                .map(Employee::department)
                .distinct()
                .forEach(System.out::println);
    }

    private static void printAverageAgeByGender() {
        var averageAgeByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age)));
        averageAgeByGender.forEach((gender, avgAge) -> System.out.println(gender + ": " + avgAge));
    }

    private static void printHighestPaidEmployee() {
        employeeList.stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .ifPresent(employee -> System.out.println("Highest Paid Employee: " + employee));
    }

    private static void printEmployeesJoinedAfter(int year) {
        employeeList.stream()
                .filter(employee -> employee.yearOfJoining() > year)
                .forEach(employee -> System.out.println(employee.name()));
    }

    private static void countEmployeesInEachDepartment() {
        var departmentCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        departmentCount.forEach((department, count) -> System.out.println(department + ": " + count));
    }

    private static void printAverageSalaryByDepartment() {
        var averageSalaryByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
        averageSalaryByDepartment.forEach((department, avgSalary) -> System.out.println(department + ": " + avgSalary));
    }

    private static void printYoungestMaleEmployeeInDepartment(String department) {
        employeeList.stream()
                .filter(employee -> "Male".equals(employee.gender()) && department.equals(employee.department()))
                .min(Comparator.comparingInt(Employee::age))
                .ifPresent(employee -> System.out.println("Youngest Male Employee in " + department + ": " + employee));
    }

    private static void printMostExperiencedEmployee() {
        employeeList.stream()
                .min(Comparator.comparingInt(Employee::yearOfJoining))
                .ifPresent(employee -> System.out.println("Most Experienced Employee: " + employee.name()));
    }

    private static void countMaleAndFemaleEmployeesInDepartment(String department) {
        var genderCountInDept = employeeList.stream()
                .filter(employee -> department.equals(employee.department()))
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
        genderCountInDept.forEach((gender, count) -> System.out.println(gender + ": " + count));
    }

    private static void listEmployeeNamesByDepartment() {
        var employeesByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::department));
        employeesByDepartment.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            employees.forEach(employee -> System.out.println(" - " + employee.name()));
        });
    }

    private static void printOrganizationSalaryStats() {
        var stats = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));
        System.out.println("Average Salary: " + stats.getAverage());
        System.out.println("Total Salary: " + stats.getSum());
    }

    private static void separateEmployeesByAge(int age) {
        var employeesByAge = employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.age() > age));
        employeesByAge.forEach((isOlder, employees) -> {
            if (isOlder) {
                System.out.println("Employees older than " + age + " years:");
            } else {
                System.out.println("Employees " + age + " years or younger:");
            }
            employees.forEach(employee -> System.out.println(" - " + employee.name()));
        });
    }

    private static void printOldestEmployeeDetails() {
        employeeList.stream()
                .max(Comparator.comparingInt(Employee::age))
                .ifPresent(employee -> System.out.println("Oldest Employee: " + employee + ", Department: " + employee.department()));
    }

    private static void printMaxSalaryOfEmployeesForEachAgeGroup() {
        // Step 1: Group employees by their age
        var employeesByAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::age));

        // Step 2: For each age group, find the employee(s) with the maximum salary
        var maxSalaryByAgeGroup = employeesByAge.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            var maxSalary = entry.getValue().stream()
                                    .mapToDouble(Employee::salary)
                                    .max()
                                    .orElse(0.0);
                            // Collect employees with the maximum salary for this age group
                            return entry.getValue().stream()
                                    .filter(employee -> employee.salary() == maxSalary)
                                    .collect(Collectors.toList());
                        }
                ));

        // Print the results
        maxSalaryByAgeGroup.forEach((age, employees) -> {
            System.out.println("Age " + age + ": " + employees);
        });
    }

    private static void printDepartmentGenderSalaryStats() {
        var employeesByDeptAndGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.groupingBy(Employee::gender)));

        employeesByDeptAndGender.forEach((department, genderMap) -> {
            genderMap.forEach((gender, employees) -> {
                var avgSalary = employees.stream()
                        .mapToDouble(Employee::salary)
                        .average()
                        .orElse(0.0);
                System.out.println("Department: " + department + ", Gender: " + gender + ", Average Salary: " + avgSalary);

                employees.stream()
                        .max(Comparator.comparingDouble(Employee::salary))
                        .ifPresent(maxSalaryEmployee -> System.out.println("Highest Salary Employee in Department: " + department + ", Gender: " + gender + ": " + maxSalaryEmployee));
            });
        });
    }
}

record Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
}