package programs.companies;

public class Toshibha {
    public static void main(String[] args) {
        String input = "0125.16.100";

        System.out.println(isValidIPAddress(input) ? "Valid" : "Invalid");
    }

    private static boolean isValidIPAddress(String input) {
        if (input == null || input.isEmpty()) return false;

        String[] parts = input.split("\\.");

        if (parts.length != 3) return false; // Expecting exactly 3 segments (A.B.C)

        for (String part : parts) {
            // Ensure part contains only digits
            if (!part.matches("\\d+")) return false;

            // Convert to integer and check range
            int number = Integer.parseInt(part);

            // Check range and leading zeros
            if (number < 0 || number > 255 || (part.length() > 1 && part.startsWith("0"))) {
                return false;
            }
        }

        return true;
    }
}
