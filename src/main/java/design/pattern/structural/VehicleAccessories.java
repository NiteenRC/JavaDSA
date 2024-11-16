package design.pattern.structural;

// Component
interface Vehicle {
    String getDescription();

    double cost();
}

// ConcreteComponent
class Car implements Vehicle {
    @Override
    public String getDescription() {
        return "Car";
    }

    @Override
    public double cost() {
        return 20000.00;
    }
}

// Decorator
abstract class VehicleDecorator implements Vehicle {
    protected Vehicle decoratedVehicle;

    public VehicleDecorator(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription();
    }

    @Override
    public double cost() {
        return decoratedVehicle.cost();
    }
}

// ConcreteDecorators
class AlloyWheels extends VehicleDecorator {
    public AlloyWheels(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription() + ", Alloy Wheels";
    }

    @Override
    public double cost() {
        return decoratedVehicle.cost() + 500.00;
    }
}

class GPSNavigation extends VehicleDecorator {
    public GPSNavigation(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription() + ", GPS Navigation";
    }

    @Override
    public double cost() {
        return decoratedVehicle.cost() + 1000.00;
    }
}

class EnhancedBreakingSystem extends VehicleDecorator {
    public EnhancedBreakingSystem(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription() + ", Enhanced Breaking System";
    }

    @Override
    public double cost() {
        return decoratedVehicle.cost() + 1500.00;
    }
}

class CustomColor extends VehicleDecorator {
    private final String color;

    public CustomColor(Vehicle decoratedVehicle, String color) {
        super(decoratedVehicle);
        this.color = color;
    }

    @Override
    public String getDescription() {
        return decoratedVehicle.getDescription() + ", Custom Color: " + color;
    }

    @Override
    public double cost() {
        return decoratedVehicle.cost() + 2000.00; // Additional cost for custom color
    }
}

// Client
public class VehicleAccessories {
    public static void main(String[] args) {
        // Base Car
        Vehicle car = new Car();
        System.out.println("Base Car: " + car.getDescription() + ", Cost: $" + car.cost());

        // Adding Alloy Wheels to Car
        Vehicle carWithAlloyWheels = new AlloyWheels(car);
        System.out.println("Car with Alloy Wheels: " + carWithAlloyWheels.getDescription() + ", Cost: $" + carWithAlloyWheels.cost());

        // Adding GPS Navigation to Car with Alloy Wheels
        Vehicle carWithAlloyWheelsAndGPS = new GPSNavigation(carWithAlloyWheels);
        System.out.println("Car with Alloy Wheels and GPS Navigation: " + carWithAlloyWheelsAndGPS.getDescription() + ", Cost: $" + carWithAlloyWheelsAndGPS.cost());

        // Adding Enhanced Breaking System to Car with Alloy Wheels and GPS Navigation
        Vehicle carWithAlloyWheelsGPSAndBreaking = new EnhancedBreakingSystem(carWithAlloyWheelsAndGPS);
        System.out.println("Car with Alloy Wheels, GPS Navigation, and Enhanced Breaking System: " + carWithAlloyWheelsGPSAndBreaking.getDescription() + ", Cost: $" + carWithAlloyWheelsGPSAndBreaking.cost());

        // Adding Custom Color to Car with Alloy Wheels, GPS Navigation, and Enhanced Breaking System
        Vehicle carWithAlloyWheelsGPSBreakingAndCustomColor = new CustomColor(carWithAlloyWheelsGPSAndBreaking, "Red");
        System.out.println("Car with Alloy Wheels, GPS Navigation, Enhanced Breaking System, and Custom Color: " + carWithAlloyWheelsGPSBreakingAndCustomColor.getDescription() + ", Cost: $" + carWithAlloyWheelsGPSBreakingAndCustomColor.cost());
    }
}

