package programs.polymorphism;

class ParentClass {
    void printValue(int a) {
        System.out.println("ONE");
    }

    void printValue(double d) {
        System.out.println("TWO");
    }
}

class ChildClass extends ParentClass {
    @Override
    void printValue(double d) {
        System.out.println("THREE");
    }
}

public class MethodOverride3 {
    public static void main(String[] args) {
        new ChildClass().printValue(100);
    }
}