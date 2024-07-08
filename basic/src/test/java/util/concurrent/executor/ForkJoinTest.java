package util.concurrent.executor;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/9/14
 * Time: 下午12:35
 */
public class ForkJoinTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        Callable<String> callable = () -> "hello world!";
        List<Callable<String>> callableList = Lists.newArrayList(callable);
        List<Future<String>> futures = pool.invokeAll(callableList);
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }
}
