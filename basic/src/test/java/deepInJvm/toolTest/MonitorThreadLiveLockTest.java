package deepInJvm.toolTest;

/**
 * Created by lcj on 15-6-8.
 */
public class MonitorThreadLiveLockTest {
    /**
     * 线程锁等待演示
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) {
        Object obj = new Object();
        createLockThread(obj);
    }
}
