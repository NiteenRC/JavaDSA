package design.pattern.behavioral.observal;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

interface Observer {
    void update(String stockSymbol, double stockPrice);
}

class Stock implements Subject {
    private final String symbol;
    private final List<Observer> observers = new ArrayList<>();
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(symbol, price));
    }
}

class Investor implements Observer {
    private final String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(name + " received update: " + stockSymbol + " price: " + stockPrice);
    }
}

public class StockImpl {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.00);
        Investor investor1 = new Investor("John");
        Investor investor2 = new Investor("Alice");

        appleStock.registerObserver(investor1);
        appleStock.registerObserver(investor2);

        // Simulate price change
        appleStock.setPrice(155.00); // Notified to John and Alice

        // Remove one observer
        appleStock.removeObserver(investor2);

        // Simulate another price change
        appleStock.setPrice(160.00); // Notified to John only because Alice was removed
    }
}