package concurrent;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc: ReentrantLock源码研究
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/22
 * Time: 下午8:12
 */
public class ReentrantLockTest {

    // ReentrantLock如何加锁
    // 1.volatile保证state的可见性
    // 2.CAS保证state的操作的原子性
    @Test
    public void howToLockTest() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new MyRunnable(lock), "thread1").start();
        Thread.sleep(30000);
        new Thread(new MyRunnable(lock), "thread2").start();
        Thread.sleep(1000000000);
    }

    private class MyRunnable implements Runnable {
        private ReentrantLock lock;

        MyRunnable(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//                lock.unlock();
            }
        }
    }
}
