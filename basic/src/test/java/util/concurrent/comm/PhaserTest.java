package util.concurrent.comm;

import org.junit.Test;

import java.util.concurrent.Phaser;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/21
 * Time: 下午1:10
 */
public class PhaserTest {

    @Test
    public void test() {
        Phaser phaser = new Phaser(1);
        System.out.println("starting...");
        new Worker("服务员", phaser).start();
        new Worker("厨师", phaser).start();
        new Worker("上菜员", phaser).start();

        for (int i = 0; i <= 3; i++) {
            phaser.arriveAndAwaitAdvance();
            System.out.println("Order " + i + " finished!");
        }
        phaser.arriveAndDeregister();
        System.out.println("All done!");
    }

    private static class Worker extends Thread {
        private final Phaser phaser;

        Worker(String name, Phaser phaser) {
            super(name);
            this.phaser = phaser;
            phaser.register();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("current order is:" + i + ":" + getName());
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
