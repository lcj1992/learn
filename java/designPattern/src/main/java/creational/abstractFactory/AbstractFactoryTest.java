package creational.abstractFactory;

/**
 * Created by lcj on 15-10-31.
 */
//GuiFactory example

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

//Concrete Factory
class Factory1 implements Factory {
    public Product1 createProduct1() {
        return new ConcreteProduct1_2();
    }

    public Product2 createProduct2() {
        return new ConcreteProduct2_2();
    }
}

//Concrete Factory
class Factory2 implements Factory {
    public Product1 createProduct1() {
        return new ConcreteProduct1_1();
    }

    public Product2 createProduct2() {
        return new ConcreteProduct2_1();
    }

}

//Concrete Product
class ConcreteProduct1_1 implements Product1 {
    public void paint() {
        System.out.println("I'm an ConcreteProduct1_1");
    }
}

//Concrete Product
class ConcreteProduct1_2 implements Product1 {
    public void paint() {
        System.out.println("I'm a ConcreteProduct1_2");
    }
}

//Concrete Product
class ConcreteProduct2_1 implements Product2 {
    public void paint() {
        System.out.println("I'm an ConcreteProduct2_1");
    }
}

//Concrete Product
class ConcreteProduct2_2 implements Product2 {
    public void paint() {
        System.out.println("I'm a ConcreteProduct2_2");
    }
}

//Client application is not aware about the how the product is created. Its only responsible to give a name of
//concrete staticfactory
public class AbstractFactoryTest {

    public static void main(String[] args) {

        Factory factory = new Factory1();

        // 产品族  button和label
        Product1 product1 = factory.createProduct1();
        Product2 product2 = factory.createProduct2();

        product1.paint();
        product2.paint();

    }
}

