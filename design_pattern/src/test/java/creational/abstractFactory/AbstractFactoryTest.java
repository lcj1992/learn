package creational.abstractFactory;

import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */
public class AbstractFactoryTest {

    @Test
    public void test() {
        Factory factory = new Factory1();

        // 产品族  button和label
        Product1 product1 = factory.createProduct1();
        Product2 product2 = factory.createProduct2();

        product1.paint();
        product2.paint();
    }


    //Abstract Product
    interface Product1 {
        void paint();
    }

    //Abstract product
    interface Product2 {
        void paint();
    }

    //Abstract Factory
    interface Factory {
        Product1 createProduct1();

        Product2 createProduct2();
    }

    static class Factory1 implements Factory {
        public Product1 createProduct1() {
            return new ConcreteProduct1_2();
        }

        public Product2 createProduct2() {
            return new ConcreteProduct2_2();
        }
    }

    static class Factory2 implements Factory {
        public Product1 createProduct1() {
            return new ConcreteProduct1_1();
        }

        public Product2 createProduct2() {
            return new ConcreteProduct2_1();
        }

    }

    static class ConcreteProduct1_1 implements Product1 {
        public void paint() {
            System.out.println("I'm an ConcreteProduct1_1");
        }
    }

    static class ConcreteProduct1_2 implements Product1 {
        public void paint() {
            System.out.println("I'm a ConcreteProduct1_2");
        }
    }

    static class ConcreteProduct2_1 implements Product2 {
        public void paint() {
            System.out.println("I'm an ConcreteProduct2_1");
        }
    }

    static class ConcreteProduct2_2 implements Product2 {
        public void paint() {
            System.out.println("I'm a ConcreteProduct2_2");
        }
    }
}

