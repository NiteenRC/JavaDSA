package programs.hashmap;

import java.util.Comparator;
import java.util.TreeMap;

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class TreeMapExample {
    public static void main(String[] args) {
        // Creating a TreeMap with a custom comparator using lambda expression
        //If we don't pass then we have to implement Comparable to the class
        TreeMap<Person, String> treeMap = new TreeMap<>(
                Comparator.comparingInt(Person::getAge).reversed()
        );

        // Adding elements to the TreeMap using method reference
        treeMap.put(new Person("Alice", 30), "Engineer");
        treeMap.put(new Person("Bob", 25), "Doctor");
        treeMap.put(new Person("Charlie", 35), "Teacher");

        // Printing the TreeMap
        treeMap.forEach((person, profession) -> System.out.println(
                "Name: " + person.getName() + ", Age: " + person.getAge() + ", Profession: " + profession
        ));
    }
}
