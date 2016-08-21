package concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * Desc: Semaphore 经典的信号量,通过计数器控制对共享资源的访问
 * 锁是特殊的信号量(只有一个信号)
 * ------------------------------------
 * Author:lichuangjian@meituan.com
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
        Person p1 = new Person("A", semaphore);
        p1.start();
        Person p2 = new Person("B", semaphore);
        p2.start();
        Person p3 = new Person("C", semaphore);
        p3.start();
        Thread.sleep(20000);
    }

    private class Person extends Thread {
        private Semaphore semaphore;

        Person(String name, Semaphore semaphore) {
            super(name);
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            System.out.println(getName() + " is waiting ...");
            try {
                long start = System.currentTimeMillis();
                semaphore.acquire();
                Thread.sleep(1000);
                System.out.println(getName() + " is done! cost time: " + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
