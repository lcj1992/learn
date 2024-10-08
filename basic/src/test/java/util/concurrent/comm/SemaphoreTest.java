package util.concurrent.comm;

import org.junit.Test;
import utils.ProcessSimulator;

import java.util.concurrent.Semaphore;

/**
 * Desc: Semaphore 经典的信号量,通过计数器控制对共享资源的访问
 * 锁是特殊的信号量(只有一个信号)
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/21
 * Time: 上午11:30
 */
public class SemaphoreTest {

    // Semaphore(int count)：创建拥有count个许可证的信号量
    // acquire()/acquire(int num)：获取1/num个许可证
    // release()/release(int num):释放1/num个许可证
    @Test
    public void test() throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        // 三个线程争两个信号量,必然有一个得等待
        Worker w1 = new Worker("A", semaphore);
        w1.start();
        Worker w2 = new Worker("B", semaphore);
        w2.start();
        Worker w3 = new Worker("C", semaphore);
        w3.start();

        w1.join();
        w2.join();
        w3.join();
    }

    private static class Worker extends Thread {
        private final Semaphore semaphore;

        Worker(String name, Semaphore semaphore) {
            super(name);
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                long start = System.currentTimeMillis();
                semaphore.acquire();
                ProcessSimulator.simulateFixedTimeConsume(500);
                System.out.println(getName() + " is done! cost time: " + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }

        }
    }
}
