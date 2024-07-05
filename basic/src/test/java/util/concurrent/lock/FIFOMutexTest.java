package util.concurrent.lock;

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
public class FIFOMutexTest {

    @Test
    public void test() throws InterruptedException {
        FIFOMutex lock = new FIFOMutex();
        Thread t1 = new Thread(() -> run(lock));
        Thread t2 = new Thread(() -> run(lock));
        t1.start();
        t2.start();
        Thread.sleep(100000);
    }

    private void run(FIFOMutex lock) {
        lock.lock();
        String current = Thread.currentThread().getName();
        try {
            long start = System.currentTimeMillis();
            Thread.sleep(5000);
            System.out.println(current + " finished ,cost time: " + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "interrupted");
        } finally {
            lock.unlock();
        }
    }

    private static class FIFOMutex {
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
            if (wasInterrupted) {         // reassert interrupt status on exit
                current.interrupt();
            }
        }

        private void unlock() {
            locked.set(false);
            LockSupport.unpark(waiters.peek());
        }
    }


}



