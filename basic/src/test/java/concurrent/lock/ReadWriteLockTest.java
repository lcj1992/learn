package concurrent.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author foolchid
 * @date 2024/6/21
 **/
public class ReadWriteLockTest {

    private static int sharedValue = 10;

    @Test
    public void test() throws InterruptedException {

        ReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock rl = rwl.readLock();
        Lock wl = rwl.writeLock();
        long start = System.currentTimeMillis();
        Thread rt = new Thread(() -> {
            rl.lock();
            try {
                Thread.sleep(1000);
                System.out.println("read value: " + sharedValue + ", cost: " + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                rl.unlock();
            }
        });
        Thread wt = new Thread(() -> {
            wl.lock();
            try {
                Thread.sleep(2000);
                sharedValue = 20;
                System.out.println("write value, cost: " + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                wl.unlock();
            }
        });
        rt.start();
        wt.start();
        rt.join();
        wt.join();
    }
}
