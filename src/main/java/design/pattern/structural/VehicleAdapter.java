package design.pattern.structural;

// Vehicle1 interface
interface Vehicle1 {
    String getDescription();

    double cost();

    void drive();
}

// Existing class representing a basic Vehicle1 format
class BasicVehicle1 {
    public void driveForward() {
        System.out.println("Basic Vehicle1 is driving forward.");
    }
}

// Adapter to make BasicVehicle1 compatible with Vehicle1 interface
class BasicVehicle1Adapter implements Vehicle1 {
    private final BasicVehicle1 basicVehicle1;

    public BasicVehicle1Adapter(BasicVehicle1 basicVehicle1) {
        this.basicVehicle1 = basicVehicle1;
    }

    @Override
    public String getDescription() {
        return "Basic Vehicle1";
    }

    @Override
    public double cost() {
        return 15000.00;
    }

    // Forward drive functionality to BasicVehicle1's driveForward method
    @Override
    public void drive() {
        basicVehicle1.driveForward();
    }
}

// Client
public class VehicleAdapter {
    public static void main(String[] args) {
        // Using BasicVehicle1 with Vehicle1 interface through Adapter
        BasicVehicle1 basicVehicle1 = new BasicVehicle1();
        Vehicle1 basicVehicle1Adapter = new BasicVehicle1Adapter(basicVehicle1);
        System.out.println("Basic Vehicle1: " + basicVehicle1Adapter.getDescription() + ", Cost: $" + basicVehicle1Adapter.cost());
        basicVehicle1Adapter.drive(); // Driving Basic Vehicle1
    }
}