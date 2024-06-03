package programs.lambda;

interface MyFunctionalInterface {
    int add(int a, int b, int c);
}

public class Lambda1 {
    public static void main(String[] args) {
        MyFunctionalInterface myInterface = (int a, int b, int c) -> a + b;
        myInterface.add(2, 3, 5);
    }
}
