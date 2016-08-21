package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/21
 * Time: 上午9:49
 */
public class ExecutorsTest {

    // executor使用的线程池,使用完毕时一定要释放。
    // 验证:
    // 主线程起一个scheduled的线程池,每隔1s触发一次,在子线程中也new一个线程池,提交任务之后
    // 使用jvisualvm观察shutdown和不shutdown线程池数量的变化
    @Test
    public void whyShutDown() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        AtomicLong atomicLong = new AtomicLong();
        executorService.scheduleAtFixedRate(() -> {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> System.out.println(atomicLong.getAndIncrement()));
            // 选择是否注释这一条来进行验证
            executor.shutdown();
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(100000);
    }

    // executorService#invokeAll会阻塞当前线程,直到所有线程执行完毕(其中的线程可能执行完成也可能抛出异常)
    @Test
    public void exceptionTest() throws InterruptedException {

        Callable<String> callable = new NormalCallable();
        Callable<String> exceptionCallable = new ExceptionCallable();
        List<Callable<String>> tasks = Lists.newArrayList(callable, exceptionCallable);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        List<Future<String>> resultList = executorService.invokeAll(tasks);
        System.out.println("cost time:" + (System.currentTimeMillis() - start));
    }

    private class NormalCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "normal";
        }
    }

    private class ExceptionCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            throw new Exception("exception");
        }
    }
}
