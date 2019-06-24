package concurrent;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/21
 * Time: 下午12:56
 */
public class CyclicBarrierTest {

    //  CyclicBarrier(int num):等待线程的数量
    //  CyclicBarrier(int num,Runnable action):等待线程的数量以及所有 线程到达后的操作
    //  await()：到达临界点后暂停线程
    @Test
    public void test() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("KPL Game start"));
        new Player("A", cyclicBarrier).start();
        new Player("B", cyclicBarrier).start();
        new Player("C", cyclicBarrier).start();
        new Player("D", cyclicBarrier).start();
        new Player("E", cyclicBarrier).start();
        Thread.sleep(1000000);
    }

    @Test
    public void testCountdownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new CountDownLatchPlayer("A", countDownLatch).start();
        new CountDownLatchPlayer("B", countDownLatch).start();
        new CountDownLatchPlayer("C", countDownLatch).start();
        new CountDownLatchPlayer("D", countDownLatch).start();
        new CountDownLatchPlayer("E", countDownLatch).start();
        countDownLatch.await();
        System.out.println("KPL Game start");
        Thread.sleep(1000000);
    }


    private class CountDownLatchPlayer extends Thread {
        private CountDownLatch countDownLatch;

        CountDownLatchPlayer(String name, CountDownLatch countDownLatch) {
            super(name);
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println(getName() + " is waiting other players...");
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class Player extends Thread {
        private CyclicBarrier cyclicBarrier;

        Player(String name, CyclicBarrier cyclicBarrier) {
            super(name);
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(getName() + " is waiting other players...");
            try {
                cyclicBarrier.await();
                System.out.println(getName() + "start playing");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
