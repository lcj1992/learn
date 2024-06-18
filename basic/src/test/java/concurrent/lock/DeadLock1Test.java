package concurrent.lock;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * Created by lcj on 15-6-8.
 */
public class DeadLock1Test {
    @Test
    public void test() throws InterruptedException {
        Resource res1 = new Resource(1);
        Resource res2 = new Resource(2);
        // 线程1首先拿到res1的锁，然后sleep 100ms，再去拿res2的锁
        Thread t1 = new Thread(new AddRunnable(res1, res2));
        t1.start();
        // 线程2首先拿到res2的锁，然后sleep 100ms，再去拿res1的锁
        Thread t2 = new Thread(new AddRunnable(res2, res1));
        t2.start();
        Thread.sleep(1000);
        // synchronized不能响应中断,所以这一行实际上是没有效果的
        t1.interrupt();
        Thread.sleep(2000);
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
            synchronized (res1) {
                Thread.sleep(100);
                synchronized (res2) {
                    System.out.println(res1.val + res2.val);
                }
            }
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class Resource {
        private Integer val;
    }
}