package creational.builder;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

public class DirectorTest {
    @Test
    public void test() {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        System.out.println(director.construct());
    }

    @Setter
    @Getter
    public static class Product {
        private int wheels;

        private String color;

        @Override
        public String toString() {
            return "Car [wheels=" + wheels + ", color=" + color + "]";
        }
    }

    interface Builder {
        void buildView();

        Product getResult();
    }

    static class ConcreteBuilder implements Builder {

        private final Product product;

        public ConcreteBuilder() {
            this.product = new Product();
        }

        @Override
        public void buildView() {
            product.setColor("Red");
            product.setWheels(4);
        }

        @Override
        public Product getResult() {
            return product;
        }
    }

    public static class Director {
        private final Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product construct() {
            builder.buildView();
            return builder.getResult();
        }


    }
}
