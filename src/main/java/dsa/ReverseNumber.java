package dsa;

public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345;
        System.out.println(reverseNumber(number));
    }

    private static int reverseNumber(int number) {
        int result = 0;

        while (number != 0) {
            int rem = number % 10;
            result = result * 10 + rem;
            number /= 10;
        }
        return result;
    }
}
