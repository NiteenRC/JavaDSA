package programs.polymorphism;

class Calculator {
    void performCalculation(int a, int b) {
        System.out.println("Class Calculator");
    }
}

class ScientificCalculator extends Calculator {
    @Override
    void performCalculation(int a, int b) {
        System.out.println("Class ScientificCalculator");
    }
}

class AdvancedCalculator extends ScientificCalculator {
    @Override
    void performCalculation(int a, int b) {
        System.out.println("Class AdvancedCalculator");
    }
}

public class MethodOverride4 {
    public static void main(String[] args) {
        Calculator calculator = new ScientificCalculator();
        calculator.performCalculation(10, 20);

        ScientificCalculator scientificCalculator = (ScientificCalculator) calculator;
        scientificCalculator.performCalculation(50, 100);

        // Attempting to cast ScientificCalculator to AdvancedCalculator
        // will throw java.lang.ClassCastException at runtime.
        // Because, ScientificCalculator cannot be cast to AdvancedCalculator
        AdvancedCalculator advancedCalculator = (AdvancedCalculator) scientificCalculator;
        advancedCalculator.performCalculation(100, 200);
    }
}