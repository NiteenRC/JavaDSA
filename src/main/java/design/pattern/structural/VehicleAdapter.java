package design.pattern.structural;

interface Car {
    void drive();

    void honk();
}

class Bicycle {
    public void pedal() {
        System.out.println("Pedaling the bicycle...");
    }

    public void ringBell() {
        System.out.println("Ringing the bicycle bell...");
    }
}

class BicycleAdapter implements Car {
    private final Bicycle bicycle;

    public BicycleAdapter(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public void drive() {
        bicycle.pedal(); // Adapting 'pedal' to 'drive'
    }

    @Override
    public void honk() {
        bicycle.ringBell(); // Adapting 'ringBell' to 'honk'
    }
}

public class VehicleAdapter {
    public static void main(String[] args) {
        Car car = new BicycleAdapter(new Bicycle());
        car.drive(); // Output: Pedaling the bicycle...
        car.honk();  // Output: Ringing the bicycle bell...
    }
}