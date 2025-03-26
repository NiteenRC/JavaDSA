package programs.companies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wolken {
    public static void main(String[] args) {
        String s = "x43#$!AByzasg";
        System.out.println(sortAlphabetsOnly(s)); // Expected Output: "A43#$!Bagsxyz"
    }

    public static String sortAlphabetsOnly(String s) {
        char[] arr = s.toCharArray();

        // Step 1: Extract letters and store them
        List<Character> letters = new ArrayList<>();
        for (char ch : arr) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }

        // Step 2: Sort letters
        Collections.sort(letters);

        // Step 3: Merge sorted letters back, preserving non-alphabetic characters
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                arr[i] = letters.get(index++);
            }
        }
        return new String(arr);
    }
}
