package classLoader;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/12
 * Time: 下午6:16
 */
public class AllClassLoaderTest {

    @Test
    public void testLoad() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            classLoader.loadClass("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
