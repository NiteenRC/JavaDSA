package programs.freq;

public class CharacterFrequencyCounter {

    /**
     * Interview Question:
     * Implement a method that counts the frequency of each character in a given string.
     * The method should return a string where each character is followed by its frequency count.
     * For example, given the input "aabbcccccaaaa", the output should be "a2b2c5a4".
     *
     * Consider edge cases such as an empty string or a string with only one type of character.
     */

    public static void main(String[] args) {
        String charCount = countCharacterFrequency("aabbcccccaaaa");
        System.out.println(charCount);
    }

    private static String countCharacterFrequency(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        char currentChar = str.charAt(0);
        int count = 0;
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (currentChar == str.charAt(i)) {
                count++;
            } else {
                resultBuilder.append(currentChar).append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }

        resultBuilder.append(currentChar).append(count);

        return resultBuilder.toString();
    }
}