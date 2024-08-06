package jvm.toolTest;

import org.junit.Test;

/**
 * Created by lcj on 15-6-8.
 */
public class ThreadBusyTest {


    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            while (true) {
            }
        }, "testBusyThread");
        thread.start();
    }

    @Test
    public void test() throws Exception {
        createBusyThread();
    }
}
