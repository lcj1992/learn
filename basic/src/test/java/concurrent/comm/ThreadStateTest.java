package concurrent.comm;

import org.junit.Test;

/**
 * @author foolchid
 * @date 2024/6/17
 **/
public class ThreadStateTest {


    /**
     *
     * wait ：
     * 1. 当前线程释放锁
     * 2. 进入obj的条件变量等待队列
     * 3. 线程状态 runnable->waiting、time_waiting
     * notify：
     * 1. 当前线程通知其他线程，处于条件变量等待队列的其他线程从条件变量等待队列进入入口等待队列
     * 2. 线程状态由waiting、time_waiting->runnable
     */
    @Test
    public void testWaitNotifyState() throws InterruptedException {
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();
        Thread t1 = new Thread(waitNotifyTest::test);
        Thread t2 = new Thread(waitNotifyTest::test);
        Thread t3 = new Thread(waitNotifyTest::test);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(3000);
    }

    public static class WaitNotifyTest {
        private final Object lock = new Object();
        private Integer counter = 1;

        public void test() {
            String threadName = Thread.currentThread().getName() + " ";
            while (true) {
                System.out.println(threadName + "I am wake up!");
                try {
                    //noinspection BusyWait
                    Thread.sleep(10);
                } catch (Exception ignored) {
                }
                synchronized (lock) {
                    try {
                        if (counter < 20) {
                            System.out.println(threadName + "enter lock block!");
                            System.out.println(threadName + "print counter: " + counter);
                            counter++;
                            //noinspection BusyWait
                            Thread.sleep(100);
                            lock.notifyAll();
                            lock.wait();
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("exception");
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
}