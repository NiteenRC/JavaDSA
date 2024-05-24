package programs.dsa;

import java.util.stream.IntStream;

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        System.out.println(strStrWithStream("abc", "c"));
    }

    public static int strStrWithLoop(String s1, String s2) {
        for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
            if (s1.startsWith(s2, i)) {
                return i;
            }
        }
        return -1;
    }

    public static int strStrWithStream(String s1, String s2) {
        return IntStream.range(0, s1.length() - s2.length() + 1)
                .filter(i -> s1.startsWith(s2, i))
                .findFirst().orElse(-1);
    }
}
