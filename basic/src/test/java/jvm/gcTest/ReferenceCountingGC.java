package jvm.gcTest;

import org.junit.Test;

/**
 * Created by lcj on 15-6-7.
 */
public class ReferenceCountingGC {
    private Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    private static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    @Test
    public void test() {
        testGC();
    }
}
