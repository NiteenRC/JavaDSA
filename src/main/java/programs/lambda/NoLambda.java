package programs.lambda;

interface MyInterface {
    int add(int a, int b);
}

public class NoLambda implements MyInterface {
    public static void main(String[] args) {
        MyInterface myInterface = new NoLambda();
        int result = myInterface.add(2, 3);
        System.out.println("result " + result);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
