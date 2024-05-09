package programs.sort;

import java.util.*;
import java.util.stream.Collectors;

/* List of Persons is given write a program for the following requirement to output the array of persons
 *
 *  0. input -> List of persons, output -> Array of Person names
 *  1. Remove all duplicate Persons objects
 *  2. Sort Persons by their name in descending order
 *  3. Extract only 3 Persons whose address in city 'New York' or Person name contains 'John'
 *  4. Get Person name in UPPER CASE
 */
public class PersonAddress {
    public static void main(String[] args) {
        Address address1 = new Address("New York");
        Address address2 = new Address("Los Angeles");
        Address address3 = new Address("New Delhi");

        // Create some Person objects and add addresses to them
        Person person1 = new Person("1", "Mark", Arrays.asList(address1, address3));
        Person person2 = new Person("2", "Alice", Arrays.asList(address2, address3));
        Person person3 = new Person("3", "Bob", Collections.singletonList(address3));
        Person person4 = new Person("1", "John", Collections.singletonList(address3));

        // Create the list of persons and add the Person objects
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(person1);
        listPerson.add(person2);
        listPerson.add(person3);
        listPerson.add(person4);

        List<String> result = listPerson.stream()
                .distinct() // Remove duplicates
                //.sorted((p1, p2) -> p2.getName().compareTo(p1.getName())) // Sort by name in descending order
                .sorted(Comparator.comparing(Person::getName).reversed()) // Sort by name in descending order
                .filter(person -> person.getAddresses().stream().anyMatch(address -> address.getCity().equals("New York")) || person.getName().equals("John")) // Filter persons living in New York or named John
                .limit(3) // Limit to 3 elements
                .map(person -> person.getName().toUpperCase()) // Map names to uppercase
                .collect(Collectors.toList()); // Collect results into a list

        System.out.println(result);
    }
}

class Person {
    private final String id;
    private final String name;
    private final List<Address> addresses;

    public Person(String id, String name, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}

class Address {
    private final String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
