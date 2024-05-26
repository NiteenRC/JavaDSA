package programs.stream;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {
    private static final List<Employee> employeeList = Arrays.asList(
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
    }

    private static void countMaleAndFemaleEmployees() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                .forEach((gender, count) -> System.out.println(gender + ": " + count));
    }

    private static void printAllDepartments() {
        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }

    private static void printAverageAgeByGender() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)))
                .forEach((gender, avgAge) -> System.out.println(gender + ": " + avgAge));
    }

    private static void printHighestPaidEmployee() {
        employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(employee -> System.out.println("Highest Paid Employee: " + employee));
    }

    private static void printEmployeesJoinedAfter(int year) {
        employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > year)
                .forEach(employee -> System.out.println(employee.getName()));
    }

    private static void countEmployeesInEachDepartment() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((department, count) -> System.out.println(department + ": " + count));
    }

    private static void printAverageSalaryByDepartment() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((department, avgSalary) -> System.out.println(department + ": " + avgSalary));
    }

    private static void printYoungestMaleEmployeeInDepartment(String department) {
        employeeList.stream()
                .filter(employee -> "Male".equals(employee.getGender()) && department.equals(employee.getDepartment()))
                .min(Comparator.comparingInt(Employee::getAge))
                .ifPresent(employee -> System.out.println("Youngest Male Employee in " + department + ": " + employee));
    }

    private static void printMostExperiencedEmployee() {
        employeeList.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .ifPresent(employee -> System.out.println("Most Experienced Employee: " + employee.getName()));
    }

    private static void countMaleAndFemaleEmployeesInDepartment(String department) {
        employeeList.stream()
                .filter(employee -> department.equals(employee.getDepartment()))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                .forEach((gender, count) -> System.out.println(gender + ": " + count));
    }

    private static void listEmployeeNamesByDepartment() {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((department, employees) -> {
                    System.out.println("Department: " + department);
                    employees.forEach(employee -> System.out.println(" - " + employee.getName()));
                });
    }

    private static void printOrganizationSalaryStats() {
        DoubleSummaryStatistics stats = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary: " + stats.getAverage());
        System.out.println("Total Salary: " + stats.getSum());
    }

    private static void separateEmployeesByAge(int age) {
        employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() > age))
                .forEach((isOlder, employees) -> {
                    if (isOlder) {
                        System.out.println("Employees older than " + age + " years:");
                    } else {
                        System.out.println("Employees " + age + " years or younger:");
                    }
                    employees.forEach(employee -> System.out.println(" - " + employee.getName()));
                });
    }

    private static void printOldestEmployeeDetails() {
        employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(employee -> System.out.println("Oldest Employee: " + employee + ", Department: " + employee.getDepartment()));
    }

    private static void printMaxSalaryOfEmployeesForEachAgeGroup() {
        // Group employees by age, then find the maximum salary for each age group and filter employees accordingly
        Map<Integer, List<Employee>> maxSalaryOfEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getAge, // Group by age
                        Collectors.collectingAndThen(
                                Collectors.toList(), // Collect into a list first
                                employees -> {
                                    // Find the maximum salary in the list
                                    double maxSalary = employees.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .max()
                                            .orElse(0.0);

                                    // Filter employees who have the maximum salary
                                    return employees.stream()
                                            .filter(emp -> emp.getSalary() == maxSalary)
                                            .collect(Collectors.toList());
                                }
                        )
                ));
        maxSalaryOfEmployees.forEach((age, employees) -> {
            System.out.println(age + ": " + employees);
        });
    }
}

class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final String gender;
    private final String department;
    private final int yearOfJoining;
    private final double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Name: %s, Age: %d, Gender: %s, Department: %s, Year Of Joining: %d, Salary: %.2f",
                id, name, age, gender, department, yearOfJoining, salary);
    }
}