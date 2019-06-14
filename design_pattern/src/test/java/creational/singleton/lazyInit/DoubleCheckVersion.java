package creational.singleton.lazyInit;

import java.util.Objects;

/**
 * Created by lcj on 15-10-31.
 */
public class DoubleCheckVersion {

    private static volatile DoubleCheckVersion instance;

    private DoubleCheckVersion() {
    }

    public static DoubleCheckVersion getInstance() {
        if (Objects.nonNull(instance)) {
            return instance;
        }
        synchronized (DoubleCheckVersion.class) {
            if (Objects.nonNull(instance)) {
                return instance;
            }
            instance = new DoubleCheckVersion();
            return instance;
        }
    }

    public void sayHello() {
        System.out.println("hello world!");
    }

}

