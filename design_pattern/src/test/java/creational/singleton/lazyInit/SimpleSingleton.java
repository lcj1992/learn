package creational.singleton.lazyInit;


/**
 * Created by lcj on 15-10-31.
 */
public class SimpleSingleton {
    private static volatile SimpleSingleton instance = null;

    private SimpleSingleton() {

    }

    public static synchronized SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    public void sayHello() {
        System.out.println("hello world");
    }
}
