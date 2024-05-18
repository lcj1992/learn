package guava;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2017/2/10
 * Time: 上午11:19
 */
public class ExecutorsTest {

    @Test
    public void test() throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(threadPool);
        executorService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ignored) {
            }
        });
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        Thread.sleep(1000);
    }


}
