package design.pattern.behavioral.template;

// VehicleRentalTemplate.java
abstract class VehicleRentalTemplate {

    // Template method
    public final void rentVehicle() {
        selectVehicle();
        calculateRentalPrice();
        processPayment();
        handOverVehicle();
    }

    // Steps to be implemented by subclasses
    protected abstract void selectVehicle();

    protected abstract void calculateRentalPrice();

    protected abstract void processPayment();

    protected abstract void handOverVehicle();
}

// CarRental.java
class CarRental extends VehicleRentalTemplate {

    @Override
    protected void selectVehicle() {
        System.out.println("Car selected for rental.");
    }

    @Override
    protected void calculateRentalPrice() {
        System.out.println("Calculating car rental price.");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing car rental payment.");
    }

    @Override
    protected void handOverVehicle() {
        System.out.println("Handing over the car to the customer.");
    }
}

// BikeRental.java
class BikeRental extends VehicleRentalTemplate {

    @Override
    protected void selectVehicle() {
        System.out.println("Bike selected for rental.");
    }

    @Override
    protected void calculateRentalPrice() {
        System.out.println("Calculating bike rental price.");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing bike rental payment.");
    }

    @Override
    protected void handOverVehicle() {
        System.out.println("Handing over the bike to the customer.");
    }
}

// TruckRental.java
class TruckRental extends VehicleRentalTemplate {

    @Override
    protected void selectVehicle() {
        System.out.println("Truck selected for rental.");
    }

    @Override
    protected void calculateRentalPrice() {
        System.out.println("Calculating truck rental price.");
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing truck rental payment.");
    }

    @Override
    protected void handOverVehicle() {
        System.out.println("Handing over the truck to the customer.");
    }
}

// TemplateMethodExample.java
public class VehicleTemplate {

    public static void main(String[] args) {
        VehicleRentalTemplate carRental = new CarRental();
        carRental.rentVehicle();

        System.out.println();

        VehicleRentalTemplate bikeRental = new BikeRental();
        bikeRental.rentVehicle();

        System.out.println();

        VehicleRentalTemplate truckRental = new TruckRental();
        truckRental.rentVehicle();
    }
}

