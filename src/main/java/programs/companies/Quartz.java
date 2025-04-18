package programs.companies;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quartz {
    public static void main(String[] args) {
        thirdHighestSalaryDistinct();
        equalityCheck();
    }

    // ✅ Method to demonstrate equals behavior
    private static void equalityCheck() {
        String str1 = "Amit";
        String str2 = "Amit";
        System.out.println("String equals: " + str1.equals(str2)); // true

        StringBuilder strbuff1 = new StringBuilder("Amit");
        StringBuilder strbuff2 = new StringBuilder("Amit");
        System.out.println("StringBuffer equals: " + strbuff1.equals(strbuff2)); // false

        // If you want to compare content
        System.out.println("StringBuffer content equals: " +
                strbuff1.toString().contentEquals(strbuff2)); // true
    }

    // ✅ Method to find the 3rd highest distinct salary and its corresponding employee(s)
    private static void thirdHighestSalaryDistinct() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1000);
        map.put("y", 1000);
        map.put("d", 5000);
        map.put("z", 5000);
        map.put("b", 7000);

        // Step 1: Get top 3 distinct salaries in descending order
        List<Integer> topSalaries = map.values().stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        int thirdHighest = topSalaries.get(2);

        System.out.println("Third highest distinct salary: " + thirdHighest);
        System.out.print("Employee(s) with third highest salary: \n");

        map.entrySet().stream()
                .filter(entry -> entry.getValue() == thirdHighest)
                .forEach(entry -> System.out.println(entry.getKey() + " "));
    }
}

