package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
            executor.shutdown();
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(100000);
    }
}
