package programs.dsa;

public class CountHomogenousSubstring {
    public static void main(String[] args) {
        System.out.println(countHomogenous("zzzzz"));
    }

    public static int countHomogenous(String s) {
        int count = 0;
        int resLoop = 0;
        int total = 0;
        char first = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (first == c) {
                count++;
            } else {
                total += (count * (count + 1)) / 2;
                //total += resLoop;
                //resLoop = 0;
                count = 1;
                first = c;
            }
        }

        total += (count * (count + 1)) / 2;

        return total;
    }
}
