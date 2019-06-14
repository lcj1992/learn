package jvm.gcTest;

import org.junit.Test;

/**
 * Created by lcj on 15-6-7.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class AllocationBigObject {
    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    @Test
    public void test() {
        testPretenureSizeThreshold();
    }
}
