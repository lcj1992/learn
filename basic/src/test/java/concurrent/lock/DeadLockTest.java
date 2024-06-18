package concurrent.lock;

import lombok.SneakyThrows;
import org.junit.Test;

/**
 * Created by lcj on 15-6-8.
 */
public class DeadLockTest {
    public static class AddRunnable implements Runnable {
        private final Integer a;
        private final Integer b;


        public AddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @SneakyThrows
        public void run() {
            synchronized (a) {
                Thread.sleep(100);
                synchronized (b) {
                    System.out.println(a + b);
                }
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        new Thread(new AddRunnable(1, 2)).start();
        new Thread(new AddRunnable(2, 1)).start();
        Thread.sleep(1000);
    }
}