package creational.facotry;

import org.junit.Test;

/**
 * Created by lcj on 15-11-8.
 */


public class FactoryTest {

    @Test
    public void test() {
        IFactory factory = new ConcreteFactory();
        IProduct product = factory.createProduct();
        product.productMethod();
    }

    interface IProduct {
        void productMethod();
    }

    static class ConcreteProduct implements IProduct {
        public void productMethod() {
            System.out.println("产品1");
        }
    }

    interface IFactory {
        IProduct createProduct();
    }

    static class ConcreteFactory implements IFactory {
        public IProduct createProduct() {
            return new ConcreteProduct();
        }
    }
}
