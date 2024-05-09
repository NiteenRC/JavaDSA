package programs.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class LastFridayOfMonth {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastFriday = findLastFridayOfMonth(currentDate.getYear(), currentDate.getMonthValue());
        System.out.println("Last Friday of the current month: " + lastFriday);
    }

    public static LocalDate findLastFridayOfMonth(int year, int month) {
        LocalDate lastDayOfMonth = LocalDate.of(year, month, 1)
                .with(TemporalAdjusters.lastDayOfMonth());

        for (int day = lastDayOfMonth.getDayOfMonth(); day >= 1; day--) {
            LocalDate candidateDate = LocalDate.of(year, month, day);
            if (candidateDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                return candidateDate;
            }
        }

        throw new RuntimeException("Friday Not Found in this month");
    }
}
