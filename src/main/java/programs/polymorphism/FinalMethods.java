package programs.polymorphism;

/**
 * A method declared as final in the superclass cannot be overridden in the subclass.
 * The final keyword prevents inheritance of the method.
 */
class Parent {
    final void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    // This will cause a compile-time error
    // @Override
    // void display() {
    //     System.out.println("Child display");
    // }
}

public class FinalMethods {
}
