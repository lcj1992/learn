package concurrent;

import org.junit.Test;

import java.util.concurrent.Exchanger;

/**
 * Desc: Exchanger 简化两个线程间数据的交换
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/21
 * Time: 下午1:06
 */
public class ExchangerTest {


    //  Exchanger:指定进行交换的数据类型
    //  V exchange(V object):等待线程到达，交换数据

    @Test
    public void test() throws InterruptedException {
        Exchanger<String> ex = new Exchanger<>();
        new A(ex).start();
        Thread.sleep(1000);
        new B(ex).start();
    }

    class A extends Thread {
        private Exchanger<String> ex;

        A(Exchanger<String> ex) {
            this.ex = ex;
        }

        @Override
        public void run() {
            String str;

            try {
                str = ex.exchange("Hello?");
                System.out.println(str);

                str = ex.exchange("A");
                System.out.println(str);

                str = ex.exchange("B");
                System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class B extends Thread {
        private Exchanger<String> ex;

        B(Exchanger<String> ex) {
            this.ex = ex;
        }

        @Override
        public void run() {
            String str;

            try {
                str = ex.exchange("Hi!");
                System.out.println(str);

                str = ex.exchange("1");
                System.out.println(str);

                str = ex.exchange("2");
                System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
