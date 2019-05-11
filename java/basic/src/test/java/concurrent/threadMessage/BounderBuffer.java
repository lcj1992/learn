package concurrent.threadMessage;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2016/12/30
 * Time: 下午5:47
 */
public class BounderBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testBounderBuffer() throws InterruptedException {
        ExecutorService producerExecutors = Executors.newFixedThreadPool(10);
        ExecutorService consumerExecutors = Executors.newFixedThreadPool(5);
        BounderBuffer buffer = new BounderBuffer();
        producerExecutors.execute(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    buffer.put(new Object());
                    System.out.println("produce one");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumerExecutors.execute(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    buffer.take();
                    System.out.println("consume one");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(100000);

    }
}
