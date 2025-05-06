package programs.companies;

import java.util.*;
import java.util.stream.Collectors;

public class Persistent {
    public static void main(String[] args) {
        // Sample employee list
        List<Employee> employees = Arrays.asList(
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

        System.out.println("\n🔹 SQL: Products not ordered");
        System.out.println("""
                    SELECT p.product
                    FROM Product p
                    LEFT JOIN Orders o ON p.productId = o.productId
                    WHERE o.productId IS NULL;
                """);

        System.out.println("\n🔹 Builder pattern example:");
        Car car = new Car.CarBuilder()
                .wheels(4)
                .color("Red")
                .build();
        System.out.println("Car -> Wheels: " + car.getWheels() + ", Color: " + car.getColor());
    }
}

// Java 14+ Record
record Employee(String name, int age, int salary, String dept) {
}

// Car Builder Pattern
class Car {
    private final int wheels;
    private final String color;

    private Car(CarBuilder builder) {
        this.wheels = builder.wheels;
        this.color = builder.color;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{wheels=" + wheels + ", color='" + color + "'}";
    }

    static class CarBuilder {
        private int wheels;
        private String color;

        public CarBuilder wheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}