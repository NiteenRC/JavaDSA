package programs.companies;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.stream.IntStream;

public class Infinix {
    public static void main(String[] args) {
        int lastFriday = getLastFridayDate();
        System.out.println("Last Friday of the month is on: " + lastFriday);

        System.out.print("Vowels in the string: ");
        fetchVowels();
    }

    // ✅ Method to get the date of the last Friday of the current month
    public static int getLastFridayDate() {
        YearMonth yearMonth = YearMonth.now(); // current year and month
        LocalDate lastDay = yearMonth.atEndOfMonth(); // get last day of month

        // Iterate backwards to find the last Friday
        while (lastDay.getDayOfWeek() != DayOfWeek.FRIDAY) {
            lastDay = lastDay.minusDays(1);
        }
        return lastDay.getDayOfMonth(); // return the date
    }

    // ✅ Method to fetch vowels using Java Streams
    public static void fetchVowels() {
        String s = "Niteen is Java developer";

        IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .forEach(System.out::print); // prints: ieeiaaeoe
        System.out.println();
    }
}
