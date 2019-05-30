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
    private final Lock LOCK = new ReentrantLock();
    private final Condition NOT_FULL = LOCK.newCondition();
    private final Condition NOT_EMPTY = LOCK.newCondition();

    private final Object[] items = new Object[100];
    private int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        LOCK.lock();
        try {
            while (count == items.length)
                NOT_FULL.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            NOT_EMPTY.signal();
        } finally {
            LOCK.unlock();
        }
    }

    public Object take() throws InterruptedException {
        LOCK.lock();
        try {
            while (count == 0)
                NOT_EMPTY.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            NOT_FULL.signal();
            return x;
        } finally {
            LOCK.unlock();
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
    }
}
