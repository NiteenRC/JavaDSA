package programs.companies;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FareAnalyzer {
    public static void main(String[] args) {
        List<Fare> fares = createFares();
        String destination = "Rome";
        findLowestFaresForDestination(fares, destination);
    }

    private static void findLowestFaresForDestination(List<Fare> fares, String destination) {
        Comparator<Fare> byPrice = Comparator.comparing(Fare::price);

        Optional<Fare> lowestFareOpt = fares.stream()
                .filter(fare -> fare.destination().equalsIgnoreCase(destination))
                .min(byPrice);

        lowestFareOpt.ifPresentOrElse(
                lowestFare -> {
                    System.out.println("\n=== Lowest Fare Details ===");
                    System.out.printf("Destination: %s%nPrice: $%d%n%n", lowestFare.destination(), lowestFare.price());

                    System.out.println("Matching Fares with Same Lowest Price:");
                    fares.stream()
                            .filter(fare -> fare.destination().equalsIgnoreCase(destination))
                            .filter(fare -> fare.price() == lowestFare.price())
                            .forEach(System.out::println);
                },
                () -> System.out.println("No fares found for destination: " + destination)
        );
    }

    private static List<Fare> createFares() {
        return List.of(
                new Fare("Rome", "American", 650),
                new Fare("Paris", "Delta", 1100),
                new Fare("Rome", "Alitalia", 700),
                new Fare("Amsterdam", "KLM", 500),
                new Fare("Rome", "Delta", 500),
                new Fare("Amsterdam", "Delta", 450),
                new Fare("Paris", "British", 900),
                new Fare("Amsterdam", "British", 900),
                new Fare("Paris", "Air France", 750),
                new Fare("Rome", "British", 500)
        );
    }
}

record Fare(String destination, String airline, int price) {
    @Override
    public String toString() {
        return String.format("Fare[destination=%s, airline=%s, price=$%d]", destination, airline, price);
    }
}