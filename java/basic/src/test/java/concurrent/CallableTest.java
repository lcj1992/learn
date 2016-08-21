package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/20
 * Time: 下午6:26
 */
public class CallableTest {


    // callable可以返回结果,runnable不可以
    // callable可以抛出异常给父线程,runnable不可以
    // executor的invokeXXX只接受callable类型,submit既接受callable类型也接受runnable类型
    @Test
    public void canResult() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // callable
        List<Future<String>> resultList = executorService.invokeAll(Lists.newArrayList(() -> "callable"));
        resultList.stream().forEach((result) -> {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        // runnable
        executorService.submit(() -> System.out.println("runnable"));
    }

}
