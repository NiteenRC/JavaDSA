package programs.design;

import java.util.Arrays;
import java.util.List;

/**
 * UserCreate shopping cart application with java main program.
 * User Java program should have cart which contains list of items.
 * User Items belong to different category like below.
 * User List<Item> cart = new ArrayList<>();
 * User Every item is associated with one category and every category has some discount.
 * User Calculate total price, total discount and total payable amount.
 * <p>
 * User Ex. 1. Almond - Category: Food, Price: 1000
 * User 2. Shirt- Category: Fashion, Price: 500
 * User 3. Jeans- Category: Fashion, Price: 500
 * User 4. Chair- Category: Furniture, Price: 1000
 * User Food has 10%, Fashion has 20% and Furniture has 50%
 * User Total Price: 1000+500+500+1000 = 3000
 * User Total Discount: 100 + 100 + 100 + 500 = 800
 * User Total Payable Amount: 3000 - 800 = 2200
 */
public class ShoppingCartDiscount {
    public static void main(String[] args) {
        Category category1 = new Category("Food", 10);
        Category category2 = new Category("Fashion", 20);
        Category category3 = new Category("Furniture", 50);

        List<Item> list = Arrays.asList(
                new Item("Almond", category1, 1000),
                new Item("Shirt", category2, 500),
                new Item("Jeans", category2, 500),
                new Item("Chair", category3, 1000));

        int totalSum = list.stream()
                .mapToInt(Item::getPrice)
                .sum();
        System.out.println("Total Price: " + totalSum);

        int totalDiscount = list.stream()
                .mapToInt(item -> (item.getPrice() * item.getCategory().getDiscount()) / 100)
                .sum();
        System.out.println("Total discount :" + totalDiscount);

        System.out.println("Total Payable : " + (totalSum - totalDiscount));
    }
}

class Item {
    private String name;
    private Category category;
    private int price;

    public Item(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class Category {
    private String name;
    private int discount;

    public Category(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}