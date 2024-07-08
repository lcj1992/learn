package utils;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午8:20
 */
public class ProcessSimulator {
    public static void simulateTimeConsume(int base, int coefficient) throws InterruptedException {
        Thread.sleep(base + (long) (Math.random() * coefficient));
    }

    public static void simulateTimeConsume(int coefficient) throws InterruptedException {
        Thread.sleep((long) (Math.random() * coefficient));
    }

    public static void simulateFixedTimeConsume(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
