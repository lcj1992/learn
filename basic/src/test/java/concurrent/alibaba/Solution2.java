package concurrent.alibaba;

import concurrent.threadMessage.produer_consumer_model.utils.IDGenerator;
import lombok.Getter;
import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午10:22
 */
public class Solution2 {

    class Printer {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private static final String SPLITTER = " - ";

        PrintRunnable newPrintRunnable(String name) {
            return new PrintRunnable(name);
        }

        @Getter
        public class PrintRunnable implements Runnable {
            private String name;

            PrintRunnable(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        int id = IDGenerator.generateId();
                        if (id > 100) {
                            return;
                        }
                        System.out.println(getName() + SPLITTER + id);
                        condition.signal();
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        Printer printer = new Printer();
        Thread thread1 = new Thread(printer.newPrintRunnable("printer1"));
        thread1.start();
        Thread thread2 = new Thread(printer.newPrintRunnable("printer2"));
        thread2.start();
        Thread.sleep(100000);
    }
}
