package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * desp:  CountDownLatch 必须发生指定数量的事件后才可以继续运行
 * Created by chuangjian.li
 * 16/3/18
 */
public class CountDownLatchTest {

    // 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
    // 和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
    // 将count值减1

    @Test
    public void test() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        MyCallable t1 = new MyCallable(countDownLatch);
        MyCallable t2 = new MyCallable(countDownLatch);
        MyCallable t3 = new MyCallable(countDownLatch);
        List<Callable<String>> callableList = Lists.newArrayList();
        callableList.add(t1);
        callableList.add(t2);
        callableList.add(t3);

        long start = System.currentTimeMillis();
        List<Future<String>> futures = service.invokeAll(callableList);
        System.out.println(System.currentTimeMillis() - start);
        boolean result = countDownLatch.await(1, TimeUnit.SECONDS);
        // todo? 为什么这里结果为false,并且中间间隔是3s而不是1s
        // answer: invokeAll会阻塞当前线程。所以这里单独执行await肯定不够1s。
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start);
        futures.stream().forEach(s -> {
            try {
                System.out.println(s.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
        Thread.sleep(10000);
    }

    private static class MyCallable implements Callable<String> {
        private CountDownLatch countDownLatch;

        MyCallable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public String call() throws Exception {
            try {
                Thread.sleep(3000);
                return "callable";
            } finally {
                countDownLatch.countDown();
            }
        }
    }

}
