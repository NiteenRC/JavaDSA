package programs.inteview;

public class TimeStampAddition {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;

    public static void main(String[] args) {
        String output = sumTime("12:02:13", "13:59:50");
        System.out.println(output); // Expected output: "02:02:03" (as time rolls over)
    }

    public static String sumTime(String timeA, String timeB) {
        String[] partsA = timeA.split(":");
        String[] partsB = timeB.split(":");

        int hours, minutes, seconds;

        try {
            seconds = Integer.parseInt(partsA[2]) + Integer.parseInt(partsB[2]);
            minutes = Integer.parseInt(partsA[1]) + Integer.parseInt(partsB[1]) + seconds / SECONDS_IN_MINUTE;
            hours = Integer.parseInt(partsA[0]) + Integer.parseInt(partsB[0]) + minutes / MINUTES_IN_HOUR;

            seconds = seconds % SECONDS_IN_MINUTE;
            minutes = minutes % MINUTES_IN_HOUR;
            hours = hours % HOURS_IN_DAY;
        } catch (NumberFormatException e) {
            return "Timestamp is Invalid";
        }

        return formatTime(hours) + ":" + formatTime(minutes) + ":" + formatTime(seconds);
    }

    private static String formatTime(int number) {
        return String.format("%02d", number);
    }
}
