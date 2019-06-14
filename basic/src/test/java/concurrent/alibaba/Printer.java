package concurrent.alibaba;

import concurrent.threadMessage.produer_consumer_model.utils.IDGenerator;

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
public class Printer {

    //    private boolean printed = false;
    private final Lock lock = new ReentrantLock();
    private final Condition printedCondition = lock.newCondition();
    private static final String SPLITTER = " - ";

    PrinterRunnable newPrintRunnable(String name) {
        return new PrintRunnableImpl(name);
    }

    public class PrintRunnableImpl extends PrinterRunnable {
        private boolean printed = false;

        PrintRunnableImpl(String name) {
            super(name);
        }

        @Override
        public void print() {
            lock.lock();
            try {
                while (printed) {
                    printedCondition.await();
                    printed = false;
                }
                int id = IDGenerator.generateId();
                System.out.println(getName() + SPLITTER + id);
                printedCondition.signal();
                printed = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
