package programs.polymorphism;

public class MethodOverloading {
    public static void main(String[] args) {
        /**
         * Which method will be invoked
         *
         * Ans: In this case, String is more specific than Object
         * because String is a subclass of Object.
         */
        new MethodOverloading().method(null); //CTE for Integer and String if Uncomment below

        new MethodOverloading().method(1);

        new MethodOverloading().method('b');

        new MethodOverloading().method(1L);

        new MethodOverloading().method(0.0);
    }

    private void method(int num) {
        System.out.println("int");
    }

   /* private void method(Integer integer) {
        System.out.println("Integer");
    }*/

    private void method(long num) {
        System.out.println("long");
    }

    private void method(String str) {
        System.out.println("String");
    }

    private void method(Object obj) {
        System.out.println("Object");
    }

    void method1(int... a) {
        System.out.println(1);
    }

    //CTE Duplicated. Because, var args (int … a) are nothing
    // but the arrays. So here, (int … a) and (int[] a) are the same.
    /*void method1(int[] a) {
        System.out.println(2);
    }*/
}

