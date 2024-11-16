package design.pattern.behavioral.strategy;

import lombok.Data;

interface PaymentStrategy {
    void pay(double amount);
}

@Data
class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String expirationDate;
    private final String cvv;

    public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

@Data
class PayPalPayment implements PaymentStrategy {
    private final String email;
    private final String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class PaymentImpl {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Choose Credit Card payment strategy
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "12/24", "123"));

        // Checkout with the chosen payment strategy
        cart.checkout(100.00); // Output: Paid 100.0 using Credit Card.

        // Change payment strategy to PayPal
        cart.setPaymentStrategy(new PayPalPayment("example@example.com", "password"));

        // Checkout with the new payment strategy
        cart.checkout(50.00); // Output: Paid 50.0 using PayPal.
    }
}
