package creational.singleton.lazyInit;


/**
 * Created by lcj on 15-10-31.
 */
public class SimpleVersion {
    private static volatile SimpleVersion instance = null;

    private SimpleVersion() {

    }

    public static synchronized SimpleVersion getInstance() {
        if (instance == null) {
            instance = new SimpleVersion();
        }
        return instance;
    }
}
