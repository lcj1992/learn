package concurrent;


import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc:
 * 1. lock.lock()、lock.tryLock()、lock.lockInterruptibly()的区别
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/20
 * Time: 上午11:36
 */
public class LockTest {

    // 验证lock.lock()不响应中断
    // 线程A先拿到锁,然后不释放锁,然后启动线程B,中断线程B
    // 线程B是否抛出异常。
    @Test
    public void lockNotInterrupt() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            long start = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " enter");
            // 不响应中断。既显式的调用thread.interrupt()不会中断加锁
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock cost time:" + (System.currentTimeMillis() - start));
        };
        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");

        threadA.start();
        threadB.start();
        threadB.interrupt();
        Thread.sleep(5000);
    }

    // lock.lock() 阻塞线程
    // 线程A首先拿到锁,同时启动线程B,线程A内sleep 5s
    // 看线程B从进入到拿到锁耗时情况
    @Test
    public void lockBlock() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            long start = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " enter");
            // lock,如果拿不到锁,则阻塞当前线程
            lock.lock();
            System.out.println(String.format("%s get lock,cost: %s", Thread.currentThread().getName(), (System.currentTimeMillis() - start)));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        };
        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");
        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(7000);
    }

    // lock.tryLock()拿到锁则返回true,拿不到则返回false
    // 线程A首先拿到锁,启动线程B,线程A内sleep 3s
    // 看线程B是否拿到锁
    @Test
    public void tryLockTest() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " enter");
                long start = System.currentTimeMillis();
                // 尝试拿锁,如果拿到,则返回true,如果拿不到返回false
                if (lock.tryLock()) {
                    System.out.println(String.format("%s get lock,cost: %s", Thread.currentThread().getName(), (System.currentTimeMillis() - start)));
                    Thread.sleep(2000);
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        Thread.sleep(3000);
    }

    // lock.tryLock(x,x)拿到锁则返回true,拿不到则返回false
    // 线程A首先拿到锁,启动线程B尝试拿锁,超时时间2s,线程A内sleep 1.5s
    // 看线程B是否拿到锁
    @Test
    public void tryLockTimeOutTest() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " enter");
                long start = System.currentTimeMillis();
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println(String.format("%s get lock,cost: %s", Thread.currentThread().getName(), (System.currentTimeMillis() - start)));
                    Thread.sleep(1500);
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        Thread.sleep(3000);
    }

    // lock.lockInterruptibly()和lock.lock()一样会阻塞当前线程,不一样的是它可以响应中断。
    // 线程A先启动,然后sleep 0.1s后启动线程B,线程A内sleep 1.1s,线程B需要等待1s左右才能获取到锁,然后在等到500ms时就中断线程B
    // 看线程B抛不抛异常啊
    @Test
    public void lockInterruptLyTest() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            long start = System.currentTimeMillis();
            try {
                System.out.println(Thread.currentThread().getName() + " enter");
                lock.lockInterruptibly();
                System.out.println(String.format("%s get lock,cost: %s", Thread.currentThread().getName(), (System.currentTimeMillis() - start)));
                Thread.sleep(1100);
                lock.unlock();
            } catch (InterruptedException e) {
                System.out.println(String.format("%s is interrupted,cost: %s", Thread.currentThread().getName(), (System.currentTimeMillis() - start)));

            }
        };
        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        // 0-2100ms都能中断到。
        Thread.sleep(500);
        threadB.interrupt();
        Thread.sleep(5000);
    }




}
