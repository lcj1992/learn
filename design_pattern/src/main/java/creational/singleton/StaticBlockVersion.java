package creational.singleton;

/**
 * Created by lcj on 15-10-31.
 *
 */
public class StaticBlockVersion {
    private static final StaticBlockVersion instance;

    private StaticBlockVersion() {
    }

    static {
        try {
            instance = new StaticBlockVersion();
        } catch (Exception e) {
            throw new RuntimeException("Darm, an error occurred", e);
        }
    }

    public static StaticBlockVersion getInstance() {
        return instance;
    }
}
