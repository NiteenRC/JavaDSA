package programs.companies;

/*
You're looking for a column-wise vertical merge of multiple
words (like "HOWB", "AR", "YOU") with character-wise alignment,
and padding missing characters with a symbol like $.
 */
public class ColumnWiseMerge {
    public static void main(String[] args) {
        // Input strings to be merged column-wise
        String[] words = {"HOWB", "AR", "YOU"};

        int maxLength = 0;

        // Step 1: Find the maximum length among all input words
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        // Step 2: Iterate over each character position (column-wise)
        for (int i = 0; i < maxLength; i++) {
            StringBuilder sb = new StringBuilder();

            // Step 3: For each word, get the character at the current index
            for (String word : words) {
                if (i < word.length()) {
                    // Append the character if it exists
                    sb.append(word.charAt(i));
                } else {
                    // Append '$' if the word is shorter than maxLength
                    sb.append('$');
                }
            }

            // Step 4: Print the constructed string for this row
            System.out.println(sb);
        }
    }
}
