package util.concurrent;

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

    @Test
    public void test() throws InterruptedException {
        TRADE_NO.set(100L);
        try {
            invokeService();
        } finally {
            TRADE_NO.remove();
        }
        Thread.sleep(1000);
    }

    private void invokeService() {
        System.out.println(TRADE_NO.get());
    }


    @Test
    public void testThreadLocalMemoryLeak() throws InterruptedException {
        // 创建一个ThreadLocal实例，用于存储线程局部变量
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                // 设置线程局部变量的值
                threadLocal.set("Value for task: " + taskId);
                // 使用线程局部变量
                System.out.println("Task ID: " + taskId + ", Value in Thread: " + Thread.currentThread().getName() + " is " + threadLocal.get());
            });
        }
        // 这里没有调用threadLocal.remove()
        // 也没有关闭线程池，这意味着线程将继续运行，持有对threadLocal的引用
        // 应该在这里调用executor.shutdown()和awaitTermination()来正确关闭线程池
        Thread.sleep(100000);
    }
}
