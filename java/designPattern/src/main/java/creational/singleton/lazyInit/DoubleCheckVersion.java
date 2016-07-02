package creational.singleton.lazyInit;

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
}
