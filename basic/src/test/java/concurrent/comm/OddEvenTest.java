package concurrent.comm;

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

    public static void main(String[] args) {
        OddEvenTest printer = new OddEvenTest();
        Thread oddThread = new Thread(printer::print);
        Thread evenThread = new Thread(printer::print);

        oddThread.start();
        evenThread.start();
    }
}