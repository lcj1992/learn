package util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/25
 * Time: 上午11:47
 */
public class FutureTaskTest {


    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    @Test
    public void testFutures() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);

        ListenableFuture<String> listenableFuture = executorService.submit(() -> {
            throw new RuntimeException("hahaha");
        });
        listenableFuture.addListener(() -> System.out.println("执行完了，可能成功，也可能异常了"), executor);
    }

    @Test
    public void testFutures2() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);

        ListenableFuture<String> listenableFuture = executorService.submit(() -> {
            throw new RuntimeException("hahaha");
        });
        listenableFuture.addListener(() -> System.out.println("执行完了，可能成功，也可能异常了"), executor);
    }
}
