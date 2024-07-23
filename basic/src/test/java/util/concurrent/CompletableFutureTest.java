package util.concurrent;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {


    @Test
    public void testThenRun() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> res = CompletableFuture
                .runAsync(() -> {
                    System.out.println("验血");
                })
                .thenRunAsync(() -> {
                    System.out.println("心电图");
                })
                .thenAcceptAsync((a) -> {
                    System.out.println("吹气");
                })
                .thenApplyAsync((a) -> {
                    System.out.println("身高体重");
                    return null;
                });
        System.out.println(res.get());
    }

    @Test
    public void testCombine() {
        //任务1：洗水壶->烧开水
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶...");
            sleep(1);

            System.out.println("T1:烧开水...");
            sleep(15);
        });
        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶...");
            sleep(1);

            System.out.println("T2:洗茶杯...");
            sleep(2);

            System.out.println("T2:拿茶叶...");
            sleep(1);
            return "龙井";
        });
        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1:拿到茶叶:" + tf);
            System.out.println("T1:泡茶...");
            return "上茶:" + tf;
        });
        //等待任务3执行结果
        System.out.println(f3.join());
    }

    void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException ignored) {
        }
    }
}
