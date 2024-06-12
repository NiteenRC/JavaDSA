package programs.sort;

public record Employee(String firstName, String lastName, String gender, int salary) {

    // Additional constructors to match different initialization needs
    public Employee(String firstName, String lastName, String gender) {
        this(firstName, lastName, gender, 0);  // Default salary to 0
    }

    public Employee(String firstName, int salary) {
        this(firstName, null, null, salary);   // Default lastName and gender to null
    }
}