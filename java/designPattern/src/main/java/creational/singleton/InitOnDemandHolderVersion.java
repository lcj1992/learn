package creational.singleton;

/**
 * Created by lcj on 15-10-31.
 *
 */
public class InitOnDemandHolderVersion {
    private InitOnDemandHolderVersion() {

    }

    private static class SingletonHolder {
        private static final InitOnDemandHolderVersion instance = new InitOnDemandHolderVersion();

    }

    private static InitOnDemandHolderVersion getInstance() {
        return SingletonHolder.instance;
    }
}
