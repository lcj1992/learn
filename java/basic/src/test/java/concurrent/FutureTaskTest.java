package concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/25
 * Time: 上午11:47
 */
public class FutureTaskTest {

    @Test
    public void test(){
        RunnableFuture<String> futureTask = new RunnableFuture<String>() {
            @Override
            public void run() {

            }

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public String get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };
    }
}
