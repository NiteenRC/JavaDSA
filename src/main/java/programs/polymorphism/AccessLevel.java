package programs.polymorphism;

/**
 * The overriding method cannot have a more restrictive access level than the method being overridden.
 * However, it can be less restrictive.
 * <p>
 * public: The method in the subclass must also be public.
 * protected: The method in the subclass can be protected or public, but not private.
 * private: Private methods in the superclass cannot be overridden since they are not visible to subclasses.
 */
class Animal {
    protected void displayInfo() {
        System.out.println("Animal Info");
    }
}

class Dog extends Animal {
    @Override
    public void displayInfo() {
        System.out.println("Dog Info");
    }
}

public class AccessLevel {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.displayInfo();  // Outputs "Animal Info"

        Dog dog = new Dog();
        dog.displayInfo();  // Outputs "Dog Info"

        Animal animalRef = new Dog();
        animalRef.displayInfo();  // Outputs "Dog Info"

        // Uncommenting the following line will cause a compile-time error (CTE)
        // Dog dogRef = new Animal();

        // This cast will compile but will throw a ClassCastException at runtime
        Dog dogRef = (Dog) new Animal();
        dogRef.displayInfo();
    }
}