package creational.singleton.lazyInit;

/**
 * Created by lcj on 15-10-31.
 *
 */
public class InitOnDemandHolderSingleton {
    private InitOnDemandHolderSingleton() {
    }

    private static class SingletonHolder {
        private static final InitOnDemandHolderSingleton instance = new InitOnDemandHolderSingleton();
    }

    public static InitOnDemandHolderSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public void sayHello() {
        System.out.println("hello");
    }
}
