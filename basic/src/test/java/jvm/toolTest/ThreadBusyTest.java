package jvm.toolTest;

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

    public static void main(String[] args) throws Exception {
        createBusyThread();
    }
}
