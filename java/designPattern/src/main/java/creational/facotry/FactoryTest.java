package creational.facotry;

/**
 * Created by lcj on 15-11-8.
 */

interface IProduct {
    void productMethod();
}

class ConcreteProduct implements IProduct {
    public void productMethod() {
        System.out.println("产品1");
    }
}

interface IFactory {
    IProduct createProduct();
}

class ConcreteFactory implements IFactory {
    public IProduct createProduct() {
        return new ConcreteProduct();
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        IFactory factory = new ConcreteFactory();
        IProduct product = factory.createProduct();
        product.productMethod();
    }
}
