package design.pattern.structural;

// Component
interface Vehicle {
    String getDescription();

    double cost();
}

// ConcreteComponent
class Truck implements Vehicle {
    @Override
    public String getDescription() {
        return "Truck";
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
        // Base Truck
        Vehicle Truck = new Truck();
        System.out.println("Base Truck: " + Truck.getDescription() + ", Cost: $" + Truck.cost());

        // Adding Alloy Wheels to Truck
        Vehicle TruckWithAlloyWheels = new AlloyWheels(Truck);
        System.out.println("Truck with Alloy Wheels: " + TruckWithAlloyWheels.getDescription() + ", Cost: $" + TruckWithAlloyWheels.cost());

        // Adding GPS Navigation to Truck with Alloy Wheels
        Vehicle TruckWithAlloyWheelsAndGPS = new GPSNavigation(TruckWithAlloyWheels);
        System.out.println("Truck with Alloy Wheels and GPS Navigation: " + TruckWithAlloyWheelsAndGPS.getDescription() + ", Cost: $" + TruckWithAlloyWheelsAndGPS.cost());

        // Adding Enhanced Breaking System to Truck with Alloy Wheels and GPS Navigation
        Vehicle TruckWithAlloyWheelsGPSAndBreaking = new EnhancedBreakingSystem(TruckWithAlloyWheelsAndGPS);
        System.out.println("Truck with Alloy Wheels, GPS Navigation, and Enhanced Breaking System: " + TruckWithAlloyWheelsGPSAndBreaking.getDescription() + ", Cost: $" + TruckWithAlloyWheelsGPSAndBreaking.cost());

        // Adding Custom Color to Truck with Alloy Wheels, GPS Navigation, and Enhanced Breaking System
        Vehicle TruckWithAlloyWheelsGPSBreakingAndCustomColor = new CustomColor(TruckWithAlloyWheelsGPSAndBreaking, "Red");
        System.out.println("Truck with Alloy Wheels, GPS Navigation, Enhanced Breaking System, and Custom Color: " + TruckWithAlloyWheelsGPSBreakingAndCustomColor.getDescription() + ", Cost: $" + TruckWithAlloyWheelsGPSBreakingAndCustomColor.cost());
    }
}

