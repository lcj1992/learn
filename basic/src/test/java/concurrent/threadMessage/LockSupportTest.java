package concurrent.threadMessage;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * Desc: LockSupport源码给出的demo
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/24
 * Time: 下午6:10
 */
public class LockSupportTest {

    static class FIFOMutex {
        private final AtomicBoolean locked = new AtomicBoolean(false);
        private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

        private void lock() {
            boolean wasInterrupted = false;
            Thread current = Thread.currentThread();
            waiters.add(current);

            // Block while not first in queue or cannot acquire lock
            while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
                long start = System.currentTimeMillis();
                LockSupport.park(this);
                System.out.println(Thread.currentThread().getName() + " LockSupport#park cost time : " + (System.currentTimeMillis() - start));
                if (Thread.interrupted()) { // ignore interrupts while waiting
                    System.out.println(Thread.currentThread().getName() + " LockSupport#park cost time : " + (System.currentTimeMillis() - start));
                    wasInterrupted = true;
                }
            }

            waiters.remove();
            if (wasInterrupted)          // reassert interrupt status on exit
                current.interrupt();
        }

        private void unlock() {
            locked.set(false);
            LockSupport.unpark(waiters.peek());
        }
    }

    @Test
    public void test() throws InterruptedException {
        FIFOMutex lock = new FIFOMutex();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            String current = Thread.currentThread().getName();
            try {
                long start = System.currentTimeMillis();
                Thread.sleep(5000);
                System.out.println(current + " finished ,cost time: " + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                System.out.println(current + "interrupted");
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();
            String current = Thread.currentThread().getName();
            try {
                long start = System.currentTimeMillis();
                Thread.sleep(2000);
                System.out.println(current + " finished ,cost time: " + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "interrupted");
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(100000);
    }
}



