package util.concurrent.executor;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
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

        Thread.sleep(10000000);
    }

    // executorService#invokeAll会阻塞当前线程,直到所有线程执行完毕(其中的线程可能执行完成也可能抛出异常)
    @Test
    public void exceptionTest() throws InterruptedException, ExecutionException {

        Callable<String> callable = new NormalCallable();
        Callable<String> exceptionCallable = new ExceptionCallable();
        @SuppressWarnings("unchecked")
        List<Callable<String>> tasks = Lists.newArrayList(callable, exceptionCallable);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        List<Future<String>> resultList = executorService.invokeAll(tasks);
        System.out.println("cost time:" + (System.currentTimeMillis() - start));
        System.out.println(resultList.get(0).get());
    }


    @Test
    public void threadStateTest() throws InterruptedException {
        AtomicLong threadNo = new AtomicLong(0);
        class RunRun implements Runnable {

            @Override
            public void run() {
                System.out.println("hhhhhhhhhh");
                long result = 0;
                for (long i = 0; i < 10000000000L; i++) {
                    result += i * i;
                }
                System.out.println(result);
            }
        }
        ExecutorService executor = new ThreadPoolExecutor(3, 8, 20L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), r -> new Thread(r, "test-" + threadNo.getAndIncrement()));
        executor.submit(new RunRun());
        executor.submit(new RunRun());
        executor.submit(new RunRun());
        executor.submit(new RunRun());
        executor.submit(new RunRun());
        executor.submit(new RunRun());
        executor.submit(new RunRun());

        Thread.sleep(300000);

    }

    @Test
    public void multiThreadTest() throws InterruptedException {
        Callable<String> callable = new NormalCallable();
        Callable<String> callable1 = new NormalCallable();
        Callable<String> callable2 = new NormalCallable();
        Callable<String> callable3 = new NormalCallable();
        Callable<String> callable4 = new NormalCallable();
        Callable<String> callable5 = new NormalCallable();
        Callable<String> callable6 = new NormalCallable();
        List<Callable<String>> tasks = Lists.newArrayList();
        tasks.add(callable);
        tasks.add(callable1);
        tasks.add(callable2);
        tasks.add(callable3);
        tasks.add(callable4);
        tasks.add(callable5);
        tasks.add(callable6);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.invokeAll(tasks);
        executorService.shutdown();

    }

    private static class NormalCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "normal";
        }
    }

    private static class ExceptionCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            throw new Exception("lang/exception");
        }
    }
}
