package lock;
/**
 * Created by lichuangjian on 16/7/27.
 * desprition:
 */
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyDemo {
    private final ReentrantLock lock;

    public LockInterruptiblyDemo() {
        lock = new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        final LockInterruptiblyDemo lockDemo = new LockInterruptiblyDemo();

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    lockDemo.lock.lockInterruptibly();
                    System.out.println(String.format("%s %s locked", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
                }
                catch (InterruptedException e) {
                    System.out.println(String.format("%s %s interrupted", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
                }
            }
        };
        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
        threadB.interrupt();
    }
}