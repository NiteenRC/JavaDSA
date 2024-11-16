package design.pattern.behavioral.observal;

import java.util.ArrayList;
import java.util.List;

/**
 * CarDealership is the concrete subject that sends special offers to customers.
 * PotentialBuyer is the concrete observer that receives offers from the dealership.
 * The client code registers customers with the dealership and sends an offer,
 * which triggers notifications to all registered customers.
 */
interface Dealership {
    void registerCustomer(Customer customer);

    void removeCustomer(Customer customer);

    void notifyCustomers(String offer);
}

interface Customer {
    void receiveOffer(String offer);
}

class CarDealership implements Dealership {
    private final List<Customer> customers = new ArrayList<>();

    public void sendOffer(String offer) {
        notifyCustomers(offer);
    }

    @Override
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void notifyCustomers(String offer) {
        for (Customer customer : customers) {
            customer.receiveOffer(offer);
        }
    }
}

class PotentialBuyer implements Customer {
    private final String name;

    public PotentialBuyer(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String offer) {
        System.out.println(name + " received offer: " + offer);
    }
}

public class VehicleOfferImpl {
    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();
        Customer customer1 = new PotentialBuyer("John");
        Customer customer2 = new PotentialBuyer("Alice");

        dealership.registerCustomer(customer1);
        dealership.registerCustomer(customer2);

        // Send offer to all registered customers
        dealership.sendOffer("Special discount on SUVs!");
    }
}
