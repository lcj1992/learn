package creational.facotry;

/**
 * Created by lcj on 15-11-8.
 */

interface IProduct {
    public void productMethod();
}

class Product implements IProduct {
    public void productMethod() {
        System.out.println("产品");
    }
}

interface IFactory {
    public IProduct createProduct();
}

class Factory implements IFactory {
    public IProduct createProduct() {
        return new Product();
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct product = factory.createProduct();
        product.productMethod();
    }
}
