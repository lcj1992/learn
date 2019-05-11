package creational.singleton.lazyInit;

import java.util.concurrent.ExecutionException;

/**
 * Created by lcj on 15-10-31.
 */
public class DoubleCheckVersion {

    private static volatile DoubleCheckVersion instance;

    private DoubleCheckVersion() {
    }

    public static DoubleCheckVersion getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckVersion.class) {
                if (instance == null) {
                    instance = new DoubleCheckVersion();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread1 = new Thread(() -> {
            DoubleCheckVersion singleton = DoubleCheckVersion.getInstance();
        });

        Thread thread2 = new Thread(() -> {
            DoubleCheckVersion singleton = DoubleCheckVersion.getInstance();
        });
        thread1.start();
        thread2.start();
    }
}
