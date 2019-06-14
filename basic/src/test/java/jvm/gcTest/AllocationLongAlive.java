package jvm.gcTest;

import org.junit.Test;

/**
 * Created by lcj on 15-6-7.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 */
public class AllocationLongAlive {
    private static final int _1MB = 1024 * 1024;

    private static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    @Test
    public void test() {
        testTenuringThreshold();
    }
}
