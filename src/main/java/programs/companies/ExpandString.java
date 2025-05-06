package programs.companies;

public class ExpandString {
    public static void main(String[] args) {
        String s = "a3b6h10c4";
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i); // read character
            i++;

            StringBuilder num = new StringBuilder();
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num.append(s.charAt(i));
                i++;
            }

            int count = Integer.parseInt(num.toString());
            while (count-- > 0) {
                result.append(ch);
            }
        }

        System.out.println(result); // Output: aaabbbbbbbbbbhcccc
    }
}