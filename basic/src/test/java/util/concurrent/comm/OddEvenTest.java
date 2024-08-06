package util.concurrent.comm;

import org.junit.Test;

public class OddEvenTest {

    private int currentNumber = 1;
    private final Object lock = new Object();

    public void print() {
        while (currentNumber <= 100) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                currentNumber++;
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    @Test
    public void test() {
        OddEvenTest printer = new OddEvenTest();
        Thread oddThread = new Thread(printer::print);
        Thread evenThread = new Thread(printer::print);

        oddThread.start();
        evenThread.start();
    }
}