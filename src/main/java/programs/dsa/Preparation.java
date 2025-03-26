package programs.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Here’s a clean format for the questions you've provided:
 * <p>
 * ---
 * <p>
 * ### 1. Find the common elements between two arrays.
 * - **Input**: Two arrays
 * - **Output**: Array of common elements
 * <p>
 * ---
 * <p>
 * ### 2. Rotate an array by `k` times.
 * - **Input**: `{1, 2, 3, 4, 5}`, `k = 3`
 * - **Output**: `{0, 0, 0, 1, 2}`
 * <p>
 * ---
 * <p>
 * ### 3. Swap two strings without using a temporary variable.
 * - **Input**: Two strings, e.g., `str1 = "abc"`, `str2 = "def"`
 * - **Output**: Swapped values of `str1` and `str2`
 * <p>
 * ---
 * <p>
 * ### 4. Find the first non-repeating character in a string.
 * - **Input**: `"swiss"`
 * - **Output**: `'w'`
 * <p>
 * ---
 * <p>
 * ### 5. Check if two words are anagrams of each other.
 * - **Input**: `"listen"`, `"silent"`
 * - **Output**: `true`
 * <p>
 * ---
 * <p>
 * ### 6. Find duplicate numbers in an array (generic for `int` and `string`).
 * - **Input**: `[1, 2, 3, 4, 2]` or `["apple", "banana", "apple"]`
 * - **Output**: Duplicates in the array
 * <p>
 * ---
 * <p>
 * ### 7. Reverse each word in a sentence.
 * - **Input**: `"Hello World"`
 * - **Output**: `"olleH dlroW"`
 * <p>
 * ---
 * <p>
 * ### 8. Print triangles/pyramids.
 * - **Input**: Size of triangle or pyramid
 * - **Output**: Pattern printed as a triangle or pyramid
 * <p>
 * ---
 * <p>
 * ### 9. Find the frequency of each word and sort by frequency.
 * - **Input**: `"apple banana apple apple banana orange"`
 * - **Output**: `{"apple": 3, "banana": 2, "orange": 1}` (sorted by frequency)
 * <p>
 * ---
 * <p>
 * Let me know if you want explanations or solutions for any of these!
 */
public class Preparation {
    public static void main(String[] args) {


        List<String> list = Arrays.asList("name, marks",
                "A,100",
                "B,200",
                "C,300");

        list.stream()
                .skip(1)
                .map(x -> new Student(x.split(",")[0], Integer.parseInt(x.split(",")[1])))
                .forEach(System.out::println);

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 87};

        int fourth = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(3).findFirst()
                .get();
        System.out.println(fourth);
    }
}

record Student(String name, int marks) {
}
