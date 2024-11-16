package design.pattern.structural;

// Vehicle2 interface
interface Vehicle2 {
    void start();

    void stop();
}

// RealSubject
class Car2 implements Vehicle2 {
    @Override
    public void start() {
        System.out.println("Car2 started");
    }

    @Override
    public void stop() {
        System.out.println("Car2 stopped");
    }
}

// Proxy
class Vehicle2Proxy implements Vehicle2 {
    private Car2 Car2;

    @Override
    public void start() {
        lazyInit();
        Car2.start();
    }

    @Override
    public void stop() {
        lazyInit();
        Car2.stop();
    }

    private void lazyInit() {
        if (Car2 == null) {
            System.out.println("Creating Car2 object...");
            Car2 = new Car2();
        }
    }
}

// Client
public class VehicleProxyImpl {
    public static void main(String[] args) {
        Vehicle2 Vehicle2 = new Vehicle2Proxy();

        // Perform operations
        Vehicle2.start();
        Vehicle2.stop();
    }
}
