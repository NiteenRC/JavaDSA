package programs.functional;

interface Vehicle {
    // Static method
    static void checkEngine() {
        System.out.println("Checking engine status.");
    }

    // Abstract method
    void drive();

    // Default method
    default void start() {
        System.out.println("Vehicle is starting.");
    }
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Car is driving.");
    }

    // Overriding the default method
    @Override
    public void start() {
        System.out.println("Car is starting with a roar!");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Bike is driving.");
    }

    // Using the default start method from Vehicle interface
}

public class InterfaceStaticDefault {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start(); // Overridden method in Car class
        car.drive();

        Vehicle bike = new Bike();
        bike.start(); // Default method from Vehicle interface
        bike.drive();

        // Calling the static method from the interface
        Vehicle.checkEngine();
    }
}
