package creational.singleton;

import creational.singleton.lazyInit.DoubleCheckSingleton;
import creational.singleton.lazyInit.InitOnDemandHolderSingleton;
import creational.singleton.lazyInit.SimpleSingleton;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/6/12
 * Time: 下午8:41
 */
public class SingletonTest {

    @Test
    public void test() {
        //eager mode
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        eagerSingleton.sayHello();

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.sayHello();

        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();
        staticBlockSingleton.sayHello();

        // lazyInit mode
        DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
        instance.sayHello();

        SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
        simpleSingleton.sayHello();

        InitOnDemandHolderSingleton initOnDemandHolderSingleton = InitOnDemandHolderSingleton.getInstance();
        initOnDemandHolderSingleton.sayHello();

    }
}
