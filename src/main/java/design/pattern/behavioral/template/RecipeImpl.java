package design.pattern.behavioral.template;

abstract class Recipe {
    // Template method
    public final void makeRecipe() {
        prepareIngredients();
        cook();
        serve();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void prepareIngredients();

    protected abstract void cook();

    // Common method
    protected void serve() {
        System.out.println("Serve the dish.");
    }
}

// Concrete subclass implementing specific steps
class PizzaRecipe extends Recipe {
    @Override
    protected void prepareIngredients() {
        System.out.println("Prepare pizza dough, sauce, and toppings.");
    }

    @Override
    protected void cook() {
        System.out.println("Bake the pizza in the oven.");
    }
}

class PastaRecipe extends Recipe {
    @Override
    protected void prepareIngredients() {
        System.out.println("Cook pasta and prepare sauce.");
    }

    @Override
    protected void cook() {
        System.out.println("Mix cooked pasta with sauce.");
    }
}

public class RecipeImpl {
    public static void main(String[] args) {
        // Make pizza
        System.out.println("Making Pizza:");
        Recipe pizza = new PizzaRecipe();
        pizza.makeRecipe();
        System.out.println();

        // Make pasta
        System.out.println("Making Pasta:");
        Recipe pasta = new PastaRecipe();
        pasta.makeRecipe();
    }
}