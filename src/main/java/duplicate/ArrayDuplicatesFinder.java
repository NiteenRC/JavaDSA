package duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayDuplicatesFinder {
    public static void main(String[] args) {
        // Find the duplicates in the array
        int[] arr = {1, 2, 3, 1, 2, 1, 3, 4, 5, 6, 7}; // output = [1,2,3]
        Set<Integer> set = new HashSet<>();


        Set<Integer> resultSet = Arrays.stream(arr)
                .boxed()
                .filter(num -> !set.add(num))
                .collect(Collectors.toSet());
        System.out.println(resultSet);
    }
}

