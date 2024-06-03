package programs.polymorphism;

/**
 * Static methods cannot be overridden since they belong to the class rather than
 * an instance of the class. Instead, they can be hidden
 * if a static method with the same signature is defined in the subclass.
 */
class ParentWithStaticMethod {
    static void display() {
        System.out.println("Parent display");
    }
}

class ChildWithHiddenStaticMethod extends ParentWithStaticMethod {
    static void display() {  // This hides the static method in Parent
        System.out.println("Child display");
    }
}

public class StaticMethods {
    public static void main(String[] args) {
        ParentWithStaticMethod.display();  // Outputs "Parent display"
        ChildWithHiddenStaticMethod.display();   // Outputs "Child display"

        ParentWithStaticMethod parentInstance = new ChildWithHiddenStaticMethod();
        parentInstance.display();// Outputs "Parent display"
    }
}