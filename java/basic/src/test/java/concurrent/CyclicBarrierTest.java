package concurrent;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/21
 * Time: 下午12:56
 */


public class CyclicBarrierTest {

    //  CyclicBarrier(int num):等待线程的数量
    //  CyclicBarrier(int num,Runnable action):等待线程的数量以及所有 线程到达后的操作
    //  await()：到达临界点后暂停线程
    @Test
    public void test() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("Game start"));

        new Player("A", cyclicBarrier).start();
        new Player("B", cyclicBarrier).start();
        new Player("C", cyclicBarrier).start();

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
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
