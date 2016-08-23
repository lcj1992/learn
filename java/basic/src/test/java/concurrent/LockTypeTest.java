package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc: 加锁的方式
 * 不需要加锁的情形:
 * 1. 共享不可变,都不可变了,再共享也不需要加锁。
 * 2. 可变不共享,虽然可变,但是不在线程之间共享,自然也不需要加锁了。
 * <p>
 * 加锁的三种方式
 * 1. Lock
 * 2. synchronized
 * 3. Atomic
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/23
 * Time: 下午7:44
 */
public class LockTypeTest {

    private static long counter = 0;

    // ReentrantLock
    @Test
    public void reentrantLockTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 100000; i++) {
            executorService.execute(() -> {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            });
        }
        Thread.sleep(5000);
        System.out.println(counter);
        executorService.shutdown();
    }

    // synchronized
    @Test
    public void synchronizedTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100000; i++) {
            executorService.execute(() -> {
                synchronized (this) {
                    counter++;
                }
            });
        }
        Thread.sleep(5000);
        System.out.println(counter);
        executorService.shutdown();
    }

    // atomic
    @Test
    public void AtomicTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        AtomicLong atomicLong = new AtomicLong(0);
        for (int i = 0; i < 100000; i++) {
            executorService.execute(atomicLong::getAndIncrement);
        }
        Thread.sleep(5000);
        System.out.println(atomicLong.get());
    }
}
