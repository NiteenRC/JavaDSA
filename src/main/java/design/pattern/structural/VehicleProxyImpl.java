package design.pattern.structural;

class RealCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving the real car...");
    }

    @Override
    public void honk() {
        System.out.println("Honking the real car horn...");
    }
}

class CarProxy implements Car {
    private final RealCar realCar;
    private final String authorizedDriver;

    public CarProxy(RealCar realCar, String authorizedDriver) {
        this.realCar = realCar;
        this.authorizedDriver = authorizedDriver;
    }

    @Override
    public void drive() {
        if (isAuthorized()) {
            System.out.println("Access granted to drive the car.");
            realCar.drive();
        } else {
            System.out.println("Access denied! Unauthorized driver.");
        }
    }

    @Override
    public void honk() {
        System.out.println("Logging: Honk triggered by a driver.");
        realCar.honk();
    }

    private boolean isAuthorized() {
        return "authorized_user".equalsIgnoreCase(authorizedDriver);
    }
}

public class VehicleProxyImpl {
    public static void main(String[] args) {
        RealCar realCar = new RealCar();

        Car authorizedProxy = new CarProxy(realCar, "authorized_user");
        Car unauthorizedProxy = new CarProxy(realCar, "unauthorized_user");

        System.out.println("=== Authorized Proxy ===");
        authorizedProxy.drive();
        authorizedProxy.honk();

        System.out.println("\n=== Unauthorized Proxy ===");
        unauthorizedProxy.drive();
        unauthorizedProxy.honk();
    }
}