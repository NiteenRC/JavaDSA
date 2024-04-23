package interview.dsa;

public class ArmStrongNumber {
    public static void main(String[] args) {
        System.out.println(check(153));
    }

    public static String check(int number) {
        int originalNumber = number;
        int sumOfCubes = 0;

        while (number != 0) {
            int digit = number % 10;
            sumOfCubes += digit * digit * digit;
            number /= 10;
        }

        return (sumOfCubes == originalNumber) ? "Yes" : "No";
    }
}