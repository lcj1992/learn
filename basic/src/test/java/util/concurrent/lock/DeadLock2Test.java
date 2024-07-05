package util.concurrent.lock;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lcj on 15-6-8.
 */
public class DeadLock2Test {

    @Test
    public void test() throws InterruptedException {
        Resource res1 = new Resource(1);
        Resource res2 = new Resource(2);
        new Thread(new AddRunnable(res1, res2)).start();
        new Thread(new AddRunnable(res2, res1)).start();
        Thread.sleep(5000);
    }

    public static class AddRunnable implements Runnable {
        private final Resource res1;
        private final Resource res2;

        public AddRunnable(Resource res1, Resource res2) {
            this.res1 = res1;
            this.res2 = res2;
        }

        @SneakyThrows
        public void run() {
            while (true) {
                boolean lock1 = res1.lock.tryLock();
                if (lock1) {
                    try {
                        //noinspection BusyWait
                        Thread.sleep(20);
                        boolean lock2 = res2.lock.tryLock();
                        if (lock2) {
                            try {
                                System.out.println(res1.val + res2.val);
                                break;
                            } finally {
                                res2.lock.unlock();
                            }
                        }
                    } finally {
                        res1.lock.unlock();
                    }
                }
                // 避免活锁，先不用管
                //noinspection BusyWait
                Thread.sleep(new Random().nextInt(100));
            }
        }
    }


    public static class Resource {
        private final Integer val;
        private final Lock lock = new ReentrantLock();

        public Resource(Integer val) {
            this.val = val;
        }

    }
}