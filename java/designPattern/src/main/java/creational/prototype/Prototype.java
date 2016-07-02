package creational.prototype;

/**
 * Created by lcj on 15-10-31.
 */
public abstract class Prototype implements Cloneable {
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
