package concurrent.comm;

import org.junit.Test;

/**
 * @author foolchid
 * @date 2024/6/20
 **/
public class HappensBeforeTest {

    private static int sharedValue = 0;
    private static volatile boolean flag = false;

    @Test
    public void test() throws InterruptedException {
        Thread wt = new Thread(() -> {
            sharedValue = 1; // 写操作1
            flag = true; // 写操作2
        });
        Thread rt = new Thread(() -> {
            while (!flag) { // 读操作1
            }
            System.out.println("after set flag, sharedValue: " + sharedValue);// 读操作2
        });

        wt.start();
        rt.start();

        wt.join();
        System.out.println("after thread join, sharedValue: " + sharedValue); // 读操作3
        rt.join();

    }
}
