package programs.backtracking;

public class Recursion {
    public static void main(String[] args) {
        //System.out.println(fact(2));
        //System.out.println(sum(100));
        //System.out.println(reverse("abcd"));
        //String s = "a";
        //System.out.println(s.substring(1));
        // System.out.println(s+'v'+'h'+"dsa");
        //int num = 123;
        //System.out.println(isPalindrom(num));
        //print(5);
        System.out.println(fib(6));
    }

    private static void print(int n) {
        if (n == 0) {
            return;
        }
        print(n - 1);
        System.out.println(n);
        System.out.println("aa");
    }

    private static boolean isPalindrom(int num) {
        return palindrome(num, 0) == num;
    }

    private static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return fact(n - 1);
    }

    private static int sum(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return n + sum(n - 2);
    }

    private static int sum1(int n) {
        if (n == 5) {
            return 5;
        }
        return n + sum1(n + 1);
    }

    private static String reverse(String s) {
        if (s.isEmpty()) return "";

        return reverse(s.substring(1)) + s.charAt(0);
    }

    private static int palindrome(int num, int res) {
        if (num == 0) {
            return res;
        }

        return palindrome(num / 10, res * 10 + num % 10);
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = fib(n - 1);
        int b = fib(n - 2);
        return a + b;
    }
}
