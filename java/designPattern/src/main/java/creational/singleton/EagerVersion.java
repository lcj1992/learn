package creational.singleton;

/**
 * Created by lcj on 15-10-31.
 *
 */
public class EagerVersion {
    private static final EagerVersion instance = new EagerVersion();

    private EagerVersion() {
    }

    public static EagerVersion getInstance() {
        return instance;
    }
}
