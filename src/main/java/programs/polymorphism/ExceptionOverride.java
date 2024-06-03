package programs.polymorphism;

import java.io.FileNotFoundException;
import java.io.IOException;

class Base {
    void doWork() throws IOException {
        System.out.println("Base work");
    }
}

class Derived extends Base {
    @Override
    void doWork() throws FileNotFoundException {//not required to handle alaso
        System.out.println("Derived work");
    }
}

public class ExceptionOverride {
    public static void main(String[] args) {
        Base base = new Derived();
        try {
            base.doWork();  // Outputs "Derived work"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
