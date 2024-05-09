package programs.polimorphism;

/**
 * Which method will be invoked
 * <p>
 * Ans: Ambiguous method call in main method only
 */
public class OverLoading2 {
    public static void main(String[] args) {
        //new OverLoading2().callWithNull(null);
    }

    private void callWithNull(String str) {
        System.out.println("String");
    }

    private void callWithNull(Integer integer) {
        System.out.println("Integer");
    }
}

