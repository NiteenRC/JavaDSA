package polimorphism;

public class OverLoading2 {
    public static void main(String[] args) {
        /**
         * Which method will be invoked
         */
        //new OverLoading2().callWithNull(null);

        //Ans: Ambiguous method call in main method only
    }

    private void callWithNull(String str) {
        System.out.println("String");
    }

    private void callWithNull(Integer integer) {
        System.out.println("Integer");
    }
}

