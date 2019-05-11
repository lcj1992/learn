package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * desc:  CountDownLatch 必须发生指定数量的事件后才可以继续运行
 * Created by chuangjian.li
 * 16/3/18
 */
public class CountDownLatchTest {

    // 任务执行线程中countdown
    // 父线程中await

    // await():
    // 1.线程会被挂起，它会等待直到count值为0才继续执行
    // 2.无返回值

    // await(x,TimeUnits.xx):
    // 1.跟await()类似,不过是带超时时间的。
    // 2.boolean返回值, 如果超时时间之内,countDownLatch将为0,返回true,否则返回false;
    // 3.超时会停止阻塞父线程,子线程会继续执行

    // countDown()
    // 将count值减1

    @Test
    public void test() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable runnable1 = new MyRunnable(countDownLatch);
        Runnable runnable2 = new MyRunnable(countDownLatch);
        Runnable runnable3 = new MyRunnable(countDownLatch);

        List<Runnable> runnableList = Lists.newArrayList(runnable1, runnable2, runnable3);

        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        runnableList.forEach(executorService::execute);
        // await()
        // 线程会被挂起，它会等待直到count值为0才继续执行,无返回值
//        countDownLatch.await();
        // await(x,TimeUnits.xx):
        // 1.跟await()类似,不过是带超时时间的和返回值
        // 2.boolean返回值, 如果超时时间之内,countDownLatch将为0,返回true,否则返回false;
        // 3.超时会停止阻塞父线程,子线程会继续执行

        boolean finished = countDownLatch.await(4, TimeUnit.SECONDS);
        System.out.println("finished: " + finished + ", cost time:" + (System.currentTimeMillis() - start));
        service.shutdown();
        Thread.sleep(10000000);
    }


    @Test
    public void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.await();
        System.out.println(countDownLatch.getCount());
        Thread.sleep(100);
    }

    @Test
    public void test2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Runnable runnable1 = new MyRunnable(countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(runnable1);
        countDownLatch.await(100L,TimeUnit.MILLISECONDS);
        System.out.println(countDownLatch.getCount());
    }

    private static class MyRunnable implements Runnable {
        private CountDownLatch countDownLatch;

        MyRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                dealTask();
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void dealTask() throws InterruptedException {
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + " deal task");
        }
    }

}
