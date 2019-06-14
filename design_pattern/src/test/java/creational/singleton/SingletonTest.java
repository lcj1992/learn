package creational.singleton;

import creational.singleton.lazyInit.DoubleCheckVersion;
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
    public void testDoubleCheck() {
        DoubleCheckVersion instance = DoubleCheckVersion.getInstance();
        instance.sayHello();
    }
}
