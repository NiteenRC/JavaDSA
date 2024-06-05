package programs.hashmap;

import java.util.HashMap;
import java.util.Objects;

class Product {
    private final int productId;
    private final String name;

    public Product(int productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name);
    }
}

public class HashMapEqualsHashCode {
    public static void main(String[] args) {
        HashMap<Product, String> map = new HashMap<>();
        Product key1 = new Product(1, "Laptop");
        Product key2 = new Product(1, "Laptop");
        Product key3 = new Product(1, "aLptop");

        map.put(key1, "Value1");
        map.put(key3, "Value3");

        // Retrieving using key2, which is equal in content but a different instance
        String value = map.get(key2);
        System.out.println(value); // Output: null, because key2 is not considered equal to key1
    }
}