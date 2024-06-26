package creational.singleton.lazyInit;

import java.util.Objects;

/**
 * Created by lcj on 15-10-31.
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (Objects.nonNull(instance)) {
            return instance;
        }
        synchronized (DoubleCheckSingleton.class) {
            if (Objects.nonNull(instance)) {
                return instance;
            }
            instance = new DoubleCheckSingleton();
            return instance;
        }
    }

    public void sayHello() {
        System.out.println("hello world!");
    }

}

