package design.pattern.creational.factory;

interface Vehicle {
    void start();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started");
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType) {
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}

public class VehicleImpl {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("Car");
        car.start();

        Vehicle bike = VehicleFactory.createVehicle("Bike");
        bike.start();
    }
}
