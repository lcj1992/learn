package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Desc: Thread#interrupt()  Just to set the interrupt flag
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/23
 * Time: 下午7:45
 */
public class ThreadInterruptTest {

    @Test
    public void interruptTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.currentThread().interrupt();
            return "hehe";
        });
        System.out.println(future.get());
    }
}
