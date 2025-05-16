package programs.companies;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SwapAdjacent {
    public static void main(String[] args) {
        // Sample employee list
        List<Employee> employees = List.of(
                new Employee("A", 25, 100, "IT"),
                new Employee("B", 30, 200, "IT"),
                new Employee("C", 28, 300, "IT"),
                new Employee("D", 32, 150, "HR"),
                new Employee("E", 27, 250, "HR"),
                new Employee("F", 35, 180, "SALES")
        );

        System.out.println("\n🔹 Department-wise 2nd highest salaried employee:");
        Map<String, List<Employee>> group = employees.stream()
                .collect(Collectors.groupingBy(Employee::dept));

        group.forEach((dept, empList) -> {
            Optional<Employee> secondHighest = empList.stream()
                    .sorted(Comparator.comparing(Employee::salary).reversed())
                    .skip(1)
                    .findFirst();

            secondHighest.ifPresent(emp ->
                    System.out.println("Dept: " + dept + ", 2nd Highest: " + emp)
            );
        });

        System.out.println("\n🔹 Third highest salaried employee overall:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .skip(2)
                .findFirst()
                .ifPresent(emp -> System.out.println("Third Highest: " + emp));

        System.out.println("\n🔹 Adjacent character swapping:");
        String s = "Abcdef";
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length - 1; i += 2) {
            char temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.println("Original: " + s + " → Swapped: " + new String(arr));
    }

    record Employee(String name, int age, int salary, String dept) { }
}