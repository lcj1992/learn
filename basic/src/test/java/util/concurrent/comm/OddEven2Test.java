package util.concurrent.comm;

import org.junit.Test;

public class OddEven2Test {

    private int currentNumber = 1;
    private final Object lock = new Object();

    public void printOdd() throws InterruptedException {
        while (currentNumber < 100) {
            synchronized (lock) {
                while (currentNumber % 2 == 0) {
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                currentNumber++;
                lock.notifyAll();
            }
        }
    }

    public void printEven() throws InterruptedException {
        while (currentNumber < 100) {
            synchronized (lock) {
                while (currentNumber % 2 != 0) {
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                currentNumber++;
                lock.notifyAll();
            }
        }
    }

    @Test
    public void test() {
        OddEven2Test printer = new OddEven2Test();
        Thread t1 = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}