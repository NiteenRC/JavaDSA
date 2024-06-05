package programs.lambda;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            StringBuilder otp = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                otp.append((int) (Math.random() * 10));
            }
            return otp.toString();
        };

        IntStream.range(0, 10).forEach(i -> {
            String otp = supplier.get();
            System.out.println("Generated OTP: " + i + ": " + otp);
        });
    }
}