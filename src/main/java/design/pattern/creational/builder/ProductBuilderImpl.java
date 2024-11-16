package design.pattern.creational.builder;

import lombok.Data;

@Data
class Product {
    private final String mandatoryField1;
    private final int mandatoryField2;
    private final String optionalField;

    private Product(ProductBuilder builder) {
        this.mandatoryField1 = builder.mandatoryField1;
        this.mandatoryField2 = builder.mandatoryField2;
        this.optionalField = builder.optionalField;
    }

    public static class ProductBuilder {
        private final String mandatoryField1;
        private final int mandatoryField2;
        private String optionalField;

        public ProductBuilder(String mandatoryField1, int mandatoryField2) {
            this.mandatoryField1 = mandatoryField1;
            this.mandatoryField2 = mandatoryField2;
        }

        public ProductBuilder optionalField(String optionalField) {
            this.optionalField = optionalField;
            return this;
        }

        public Product build() {
            if (mandatoryField1 == null || optionalField == null) {
                throw new IllegalStateException("Mandatory fields cannot be null");
            }
            return new Product(this);
        }
    }
}

public class ProductBuilderImpl {
    public static void main(String[] args) {
        Product product = new Product.ProductBuilder("Mandatory1", 100).optionalField("Optional").build();
        System.out.println(product.getMandatoryField1() + " " + product.getMandatoryField2() + " " + product.getOptionalField());
    }
}
