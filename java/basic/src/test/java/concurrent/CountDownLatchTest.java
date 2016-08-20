package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by chuangjian.li
 * 16/3/18
 */
public class CountDownLatchTest {


    //
    @Test
    public void test() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        MyCallable t1 = new MyCallable(countDownLatch);
        MyCallable t2 = new MyCallable(countDownLatch);
        List<Callable<String>> callableList = Lists.newArrayList();
        callableList.add(t1);
        callableList.add(t2);
        List<Future<String>> futures = service.invokeAll(callableList);
        countDownLatch.await(1, TimeUnit.SECONDS);
        futures.stream().forEach(s -> {
            try {
                System.out.println(s.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        });
        service.shutdown();
    }


    private static class MyCallable implements Callable<String> {

        private CountDownLatch countDownLatch;

        MyCallable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public String call() throws Exception {
            try {
                Thread.sleep(10000);
                return "hehe";
            } finally {
                countDownLatch.countDown();
            }
        }
    }

}
