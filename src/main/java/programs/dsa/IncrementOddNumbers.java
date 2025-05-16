package programs.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Increment odd numbers only and don't use a new arraylist to store results?
 * List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
 * Output = 2,2,4,4,6,6
 */
public class IncrementOddNumbers {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> result = list.stream()
                .map(num -> (num % 2 != 0) ? num + 1 : num); //num++ won't work

        result.forEach(System.out::println);
    }
}
