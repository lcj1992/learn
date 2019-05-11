package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2017/8/1
 * Time: 下午12:03
 */
public class ThreadLocalTest {

    private static ThreadLocal<Long> tradeNo = new InheritableThreadLocal<>();
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Test
    public void test() throws InterruptedException {
        Long x = tradeNo.get();
        executorService.submit(() -> System.out.println(x));
        Thread.sleep(1000);
    }
}
