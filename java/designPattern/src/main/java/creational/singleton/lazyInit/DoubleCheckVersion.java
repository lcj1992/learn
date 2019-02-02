package creational.singleton.lazyInit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lcj on 15-10-31.
 */
public class DoubleCheckVersion {

    private static volatile DoubleCheckVersion instance;

    private DoubleCheckVersion() {
    }

    public static DoubleCheckVersion getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckVersion.class) {
                if (instance == null) {
                    instance = new DoubleCheckVersion();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start= System.currentTimeMillis();
        Future<Integer> future =  executorService.submit(() -> {
            if(false){
                return 1;
            }
            throw new RuntimeException();
        });
        System.out.println(System.currentTimeMillis() - start);
        Thread.sleep(10000);
        System.out.println(future.get());
        System.out.println(System.currentTimeMillis() - start);
        Thread.sleep(100000);
    }
}
