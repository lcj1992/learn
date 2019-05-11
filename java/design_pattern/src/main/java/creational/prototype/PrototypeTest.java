package creational.prototype;

/**
 * Created by lcj on 15-10-31.
 */
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype prototype = new ConcretePrototype();
        for (int i = 0; i < 5; i++) {
            ConcretePrototype cp = (ConcretePrototype) prototype.clone();
            cp.show();
        }
    }
}
