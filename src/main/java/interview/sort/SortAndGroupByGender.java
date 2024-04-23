package interview.sort;

import java.util.*;
import java.util.stream.Collectors;

class User {
    private final String firstName;
    private final String lastName;
    private final String gender;

    public User(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + gender + ")";
    }
}

public class SortAndGroupByGender {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John", "Doe", "Male"),
                new User("Jane", "Smith", "Female"),
                new User("Alice", "Johnson", "Female"),
                new User("Bob", "Smith", "Male"),
                new User("Eve", "Doe", "Female"),
                new User("Charlie", "Brown", "Male")
        );

        // Sort by firstName and then by lastName
        List<User> sortedUsers = users.stream()
                .sorted(Comparator.comparing(User::getFirstName).thenComparing(User::getLastName))
                .collect(Collectors.toList());

        // Group by gender
        Map<String, List<User>> groupedByGender = new HashMap<>();
        for (User user : sortedUsers) {
            groupedByGender.computeIfAbsent(user.getGender(), k -> new ArrayList<>()).add(user);
        }

        // Print the sorted and grouped list
        System.out.println("Sorted and grouped by gender:");
        groupedByGender.forEach((gender, userList) -> {
            System.out.println("Gender: " + gender);
            for (User u : userList) {
                System.out.println("  " + u);
            }
        });
    }
}