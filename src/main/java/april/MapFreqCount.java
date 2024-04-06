package april;

public class MapFreqCount {
    public static void main(String[] args) {
        String charCount = calculateCharacterFrequency("aabbccccc");
        System.out.println(charCount);
    }

    private static String calculateCharacterFrequency(String str) {
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
