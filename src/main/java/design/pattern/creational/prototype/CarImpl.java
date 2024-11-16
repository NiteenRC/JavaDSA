package design.pattern.creational.prototype;

import lombok.Data;

interface Prototype {
    Prototype clone();
}

@Data
class Car implements Prototype {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(Car car) {
        this.brand = car.brand;
    }

    @Override
    public Prototype clone() {
        return new Car(this); // Create a new Car object with the same brand
    }

    public void display() {
        System.out.println("Car brand: " + brand);
    }
}

public class CarImpl {
    public static void main(String[] args) {
        // Create a prototype
        Car originalCar = new Car("Toyota");

        // Clone the prototype
        Car clonedCar = (Car) originalCar.clone();

        // Display original and cloned car brands
        originalCar.display(); // Output: Car brand: Toyota
        clonedCar.display();   // Output: Car brand: Toyota

        // Modify the cloned car
        clonedCar.setBrand("Honda");

        // Display original and cloned car brands again
        originalCar.display(); // Output: Car brand: Toyota
        clonedCar.display();   // Output: Car brand: Honda
    }
}
