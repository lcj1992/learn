package creational.builder;
/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/16
 * Time: 下午4:27
 */

class Product {
    private int wheels;

    private String color;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [wheels=" + wheels + ", color=" + color + "]";
    }
}

interface Builder {
    void buildView();

    Product getResult();
}

class ConcreteBuilder implements Builder {

    private Product product;


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

public class Director {


    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct(){
        builder.buildView();
        return builder.getResult();
    }
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        System.out.println(director.construct());
    }
}