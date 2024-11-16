package design.pattern.behavioral.observal;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Vehicle {
    void addObserver(VehicleObserver observer);

    void removeObserver(VehicleObserver observer);

    void notifyObservers();
}

// Observer interface
interface VehicleObserver {
    void update(String location);
}

// Concrete Subject
class Car implements Vehicle {
    private final List<VehicleObserver> observers;
    private String location;

    public Car() {
        this.observers = new ArrayList<>();
    }

    public void drive(String newLocation) {
        this.location = newLocation;
        notifyObservers();
    }

    @Override
    public void addObserver(VehicleObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(VehicleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (VehicleObserver observer : observers) {
            observer.update(location);
        }
    }
}

// Concrete Observer
class TrafficPolice implements VehicleObserver {
    @Override
    public void update(String location) {
        if (location.equals("School")) {
            System.out.println("Traffic Police: Slow down near the school area.");
        }
    }
}

// Concrete Observer
class GPSNavigation implements VehicleObserver {
    @Override
    public void update(String location) {
        System.out.println("GPS Navigation: Vehicle is now at " + location);
    }
}

public class VehicleImpl {
    public static void main(String[] args) {
        // Create the subject (car)
        Car car = new Car();

        // Create observers
        VehicleObserver trafficPolice = new TrafficPolice();
        VehicleObserver gpsNavigation = new GPSNavigation();

        // Register observers with the subject
        car.addObserver(trafficPolice);
        car.addObserver(gpsNavigation);

        // Simulate driving
        car.drive("School");
        car.drive("Office");
    }
}