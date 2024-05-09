package programs.polimorphism;

public class OverLoading1 {
    public static void main(String[] args) {
        /**
         * Which method will be invoked
         *
         * Ans: In this case, String is more specific than Object
         * because String is a subclass of Object.
         */
        new OverLoading1().callWithNull(null);
    }

    private void callWithNull(String str) {
        System.out.println("String");
    }

    private void callWithNull(Object obj) {
        System.out.println("Object");
    }
}

