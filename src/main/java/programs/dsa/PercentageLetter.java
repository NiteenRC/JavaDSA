package programs.dsa;

public class PercentageLetter {
    public static void main(String[] args) {
        System.out.println(usingStream("food", 'o'));
    }

    public static int usingLoop(String s, char letter) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                count++;
            }
        }
        return (count * 100) / s.length();
    }

    public static int usingStream(String s, char letter) {
        long count = s.chars()
                .filter(c -> c == letter)
                .count();
        return (int) (count * 100) / s.length();
    }
}
