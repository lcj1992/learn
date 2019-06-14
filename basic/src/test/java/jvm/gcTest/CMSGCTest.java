package jvm.gcTest;

import org.junit.Test;

/**
 * Desc: -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/6/1
 * Time: 下午9:34
 */
public class CMSGCTest {
    private static final int _1MB = 1024 * 1024;

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(10000);
        int flag = 1;
        flag += 1;
        if (flag == 2) {
            byte[] allocation1 = new byte[2 * _1MB];
            byte[] allocation2 = new byte[2 * _1MB];
            byte[] allocation3 = new byte[2 * _1MB];
            byte[] allocation4 = new byte[4 * _1MB];
        }
        Thread.sleep(3000);
    }
}
