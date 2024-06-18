package concurrent.lock;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lcj on 15-6-8.
 */
public class DeadLock2Test {
    public static class AddRunnable implements Runnable {
        private final Lock lockA = new ReentrantLock();
        private final Lock lockB = new ReentrantLock();
        private final Integer a;
        private final Integer b;


        public AddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @SneakyThrows
        public void run() {
            boolean lock1 = lockA.tryLock();
            try {
                if (lock1) {
                    Thread.sleep(3000);
                    boolean lock2 = lockB.tryLock();
                    try {
                        if (lock2) {
                            System.out.println(a + b);
                        }
                    } finally {
                        if (lock2) {
                            lockB.unlock();
                        }
                    }
                }
            } finally {
                if (lock1) {
                    lockA.unlock();
                }
            }

        }
    }

    @Test
    public void test() throws InterruptedException {
        new Thread(new AddRunnable(1, 2)).start();
        new Thread(new AddRunnable(2, 1)).start();
        Thread.sleep(5000);
    }
}