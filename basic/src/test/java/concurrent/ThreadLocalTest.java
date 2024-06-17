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

    private static final ThreadLocal<Long> TRADE_NO = new InheritableThreadLocal<>();
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    @Test
    public void test() throws InterruptedException {
        Long x = TRADE_NO.get();
        EXECUTOR_SERVICE.submit(() -> System.out.println(x));
        Thread.sleep(1000);
    }
}
