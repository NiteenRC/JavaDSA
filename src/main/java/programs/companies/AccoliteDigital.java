package programs.companies;

/**
 * Interview Question:
 * Implement a method that toggles the case of each character in a given string.
 * - If the character is in uppercase, convert it to lowercase.
 * - If the character is in lowercase, convert it to uppercase.
 * - Non-alphabetic characters should remain unchanged.
 *
 * For example:
 * Input: "I Work At Accolite Digital"
 * Output: "i wORK aT aCCOLITE dIGITAL"
 *
 * Consider edge cases such as an empty string or strings with no alphabetic characters.
 */
public class AccoliteDigital {
    public static void main(String[] args) {
        String s = "I Work At Accolite Digital";
        StringBuilder output = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 65 && ch <= 90) {
                output.append(Character.toLowerCase(ch));
            } else if (ch >= 97 && ch <= 122) {
                output.append(Character.toUpperCase(ch));
            } else {
                output.append(ch);
            }
        }
        System.out.println(output);
    }
}