package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Desc:
 * Thread#interrupt():  just to set the interrupt flag
 * thread1#join():  wait until the thread1 die or timeout
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/23
 * Time: 下午7:45
 */
public class ThreadTest {

    // interupt() 只是设置中断标志位，并不会影响执行。一些方法会判断中断标志位，然后抛出InterruptedException
    @Test
    public void interruptTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.currentThread().interrupt();
            return "hehe";
        });
        System.out.println(future.get());
    }

    @Test
    public void joinTest() {
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");

        t1.start();

        //start second thread after waiting for 2 seconds or if it's dead
        try {
            long start = System.currentTimeMillis();
            // 等待t1 die 或者超时,如果超时了,不会影响t1的执行。
            t1.join(2000);
            System.out.println("线程1内sleep4s, join等了2s: " + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        //start third thread only when first thread is dead
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();

        //let all threads finish execution before finishing main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("All threads are dead, exiting main thread");
    }


    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread started: " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread ended: " + Thread.currentThread().getName());
        }
    }
}
