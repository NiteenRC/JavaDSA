package programs.dsa;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(method1("A      Man    nama"));
    }

    public static boolean method1(String s) {
        int i = 0, j = s.length() - 1;

        while (i <= j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (Character.toLowerCase(s.charAt(i))
                    != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
