package jvm.memTest;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by lcj on 15-6-6.
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOMTest {
    private static final int _1MB = 1024 * 1024;

    @Test
    public void test() throws IllegalAccessException {
        Field unSafeField = Unsafe.class.getDeclaredFields()[0];
        unSafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unSafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
