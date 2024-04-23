package interview.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class LocalDateExamples {
    public static void main(String[] args) {
        // Test age calculation
        LocalDate birthDate = LocalDate.of(1987, 1, 1);
        System.out.println("Age: " + calculateAge(birthDate));

        // Test days between dates
        LocalDate startDate = LocalDate.of(2024, 4, 1);
        LocalDate endDate = LocalDate.of(2024, 4, 30);
        System.out.println("Days between dates: " + daysBetweenDates(startDate, endDate));

        // Test leap year checker
        LocalDate leapYearDate = LocalDate.of(2020, 1, 1);
        System.out.println("Is leap year: " + isLeapYear(leapYearDate));

        // Test working days calculation
        LocalDate startWorkingDate = LocalDate.of(2024, 4, 1);
        int workingDays = 10;
        System.out.println("End working date: " + calculateEndWorkingDays(startWorkingDate, workingDays));

        // Test next Friday finder
        LocalDate currentDate = LocalDate.now();
        System.out.println("Next Friday: " + findNextFriday(currentDate));

        // Test weekend counter
        LocalDate startWeekendCountDate = LocalDate.of(2024, 4, 1);
        int weeks = 2;
        System.out.println("Weekend days count: " + countWeekendDays(startWeekendCountDate, weeks));

        // Test holiday checker
        LocalDate holidayDate = LocalDate.of(2024, 1, 1);
        List<LocalDate> publicHolidays = new ArrayList<>();
        publicHolidays.add(holidayDate);
        System.out.println("Is public holiday: " + isPublicHoliday(holidayDate, publicHolidays));

        // Test quarter determination
        LocalDate quarterDate = LocalDate.of(2024, 5, 15);
        System.out.println("Quarter: " + determineQuarter(quarterDate));

        // Test date formatter
        LocalDate formattedDate = LocalDate.of(2024, 4, 15);
        String format = "MM/dd/yyyy";
        System.out.println("Formatted date: " + formatDate(formattedDate, format));
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public static long daysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return endDate.toEpochDay() - startDate.toEpochDay();
    }

    public static boolean isLeapYear(LocalDate date) {
        return date.getYear() % 4 == 0 && (date.getYear() % 100 != 0 || date.getYear() % 400 == 0);
    }

    public static LocalDate calculateEndWorkingDays(LocalDate startDate, int workingDays) {
        int daysToAdd = 0;
        LocalDate currentDate = startDate;
        while (daysToAdd < workingDays) {
            currentDate = currentDate.plusDays(1);
            if (currentDate.getDayOfWeek() != DayOfWeek.SATURDAY && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                daysToAdd++;
            }
        }
        return currentDate;
    }

    public static LocalDate findNextFriday(LocalDate currentDate) {
        return currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    }

    public static int countWeekendDays(LocalDate startDate, int weeks) {
        int weekendDays = 0;
        LocalDate endDate = startDate.plusWeeks(weeks);
        while (startDate.isBefore(endDate)) {
            if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekendDays++;
            }
            startDate = startDate.plusDays(1);
        }
        return weekendDays;
    }

    public static boolean isPublicHoliday(LocalDate date, List<LocalDate> publicHolidays) {
        return publicHolidays.contains(date);
    }

    public static int determineQuarter(LocalDate date) {
        return (date.getMonthValue() - 1) / 3 + 1;
    }

    public static String formatDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }
}