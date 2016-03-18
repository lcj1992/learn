package test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by chuangjian.li
 * 16/3/18
 */
public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch  = new CountDownLatch(2);
        MyCallable t1 = new MyCallable(countDownLatch);
        MyCallable t2 = new MyCallable(countDownLatch);
        List<Callable<String>> callables = Lists.newArrayList();
        callables.add(t1);
        callables.add(t2);
        List<Future<String>> futures = service.invokeAll(callables);
        countDownLatch.await(1,TimeUnit.SECONDS);
        service.shutdown();
    }


    static class MyCallable implements Callable<String> {

        private CountDownLatch countDownLatch;

        MyCallable(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        public String call() throws Exception {
            try{
                Thread.sleep(4000);
                System.out.println("hehe");
                return "hehe";
            }finally {
                countDownLatch.countDown();
            }
        }
    }
}
