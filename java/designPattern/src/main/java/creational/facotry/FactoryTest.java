package creational.facotry;

/**
 * Created by lcj on 15-11-8.
 *
 */

interface IProduct {
    public void productMethod();
}

class Product1 implements IProduct {
    public void productMethod() {
        System.out.println("产品1");
    }
}

interface IFactory {
    public IProduct createProduct();
}

class Factory1 implements IFactory {
    public IProduct createProduct() {
        return new Product1();
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        IFactory factory = new Factory1();
        IProduct product = factory.createProduct();
        product.productMethod();
    }
}
