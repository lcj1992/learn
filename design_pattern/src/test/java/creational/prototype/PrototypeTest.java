package creational.prototype;

import org.junit.Test;

/**
 * Created by lcj on 15-10-31.
 */
public class PrototypeTest {

    @Test
    public void test() throws CloneNotSupportedException {
        ConcretePrototype prototype = new ConcretePrototype();
        for (int i = 0; i < 5; i++) {
            ConcretePrototype cp = (ConcretePrototype) prototype.clone();
            cp.show();
        }
    }

    public static class ConcretePrototype extends Prototype {
        public void show() {
            System.out.println("原型模式实现类");
        }
    }


    public abstract static class Prototype implements Cloneable {

        public Prototype clone() throws CloneNotSupportedException {
            return (Prototype) super.clone();
        }
    }
}
