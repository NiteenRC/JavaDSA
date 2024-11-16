package design.pattern.behavioral.strategy;

// RentalStrategy.java
interface RentalStrategy {
    double calculateRental(int daysRented);
}

// DailyRentalStrategy.java
class DailyRentalStrategy implements RentalStrategy {
    private static final double DAILY_RATE = 30.0;

    @Override
    public double calculateRental(int daysRented) {
        return daysRented * DAILY_RATE;
    }
}

// WeeklyRentalStrategy.java
class WeeklyRentalStrategy implements RentalStrategy {
    private static final double WEEKLY_RATE = 150.0;

    @Override
    public double calculateRental(int daysRented) {
        int weeksRented = (daysRented + 6) / 7; // Round up to the nearest week
        return weeksRented * WEEKLY_RATE;
    }
}

// MonthlyRentalStrategy.java
class MonthlyRentalStrategy implements RentalStrategy {
    private static final double MONTHLY_RATE = 500.0;

    @Override
    public double calculateRental(int daysRented) {
        int monthsRented = (daysRented + 29) / 30; // Round up to the nearest month
        return monthsRented * MONTHLY_RATE;
    }
}

// VehicleRentalImpl.java
class VehicleRental {
    private RentalStrategy rentalStrategy;

    public void setRentalStrategy(RentalStrategy rentalStrategy) {
        this.rentalStrategy = rentalStrategy;
    }

    public double calculateRentalCost(int daysRented) {
        if (rentalStrategy != null) {
            return rentalStrategy.calculateRental(daysRented);
        } else {
            throw new IllegalStateException("Rental strategy not set.");
        }
    }
}

// StrategyPatternExample.java
public class VehicleRentalImpl {
    public static void main(String[] args) {
        VehicleRental rental = new VehicleRental();

        // Set rental strategy to Daily and calculate rental cost
        rental.setRentalStrategy(new DailyRentalStrategy());
        System.out.println("Daily Rental Cost for 5 days: " + rental.calculateRentalCost(5)); // Output: 150.0

        // Set rental strategy to Weekly and calculate rental cost
        rental.setRentalStrategy(new WeeklyRentalStrategy());
        System.out.println("Weekly Rental Cost for 10 days: " + rental.calculateRentalCost(10)); // Output: 300.0

        // Set rental strategy to Monthly and calculate rental cost
        rental.setRentalStrategy(new MonthlyRentalStrategy());
        System.out.println("Monthly Rental Cost for 40 days: " + rental.calculateRentalCost(40)); // Output: 1000.0
    }
}