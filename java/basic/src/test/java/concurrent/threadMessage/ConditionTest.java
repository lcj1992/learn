package concurrent.threadMessage;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/24
 * Time: 下午7:17
 */
public class ConditionTest {

    // wait和notify
    @Test
    public void test() throws InterruptedException {
        List<Integer> taskQueue = Lists.newArrayList();
        int MAX_CAPACITY = 6;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        tProducer.start();
        tConsumer.start();
        Thread.sleep(100000);
    }

//    private static final Lock lock = new ReentrantLock(true);
    private static final Lock lock = new ReentrantLock();

    // 队列满了
    private static final Condition isFull = lock.newCondition();

    // 队列空了
    private static final Condition isEmpty = lock.newCondition();

    private class Producer implements Runnable {
        private final List<Integer> taskQueue;
        private final int MAX_CAPACITY;

        Producer(List<Integer> sharedQueue, int size) {
            this.taskQueue = sharedQueue;
            this.MAX_CAPACITY = size;
        }

        @Override
        public void run() {
            int counter = 0;
            while (true) {
                try {
                    produce(counter++);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        private void produce(int i) throws InterruptedException {
            lock.lock();
            try {
                while (taskQueue.size() >= MAX_CAPACITY) {
                    System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                    // 当前线程释放对taskQueue的monitor(锁),
                    // 直到别的线程(必须是别的,参见 WaitNotifyTest#notifyMustOtherThread)调用taskQueue.notify()或者notifyAll(),该线程才可能恢复到taskQueue的monitor

                    // 满了,生产者等等
                    isFull.await();
                }

                Thread.sleep(1000);
                taskQueue.add(i);
                // 不空了
                isEmpty.signalAll();
                System.out.println("Produced, " + "size:" + taskQueue.size());
            } finally {
                lock.unlock();
            }
        }
    }

    private class Consumer implements Runnable {
        private final List<Integer> taskQueue;

        Consumer(List<Integer> sharedQueue) {
            this.taskQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consume();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            lock.lock();
            try {
                while (taskQueue.isEmpty()) {
                    System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                    // 空了,消费者等等
                    isEmpty.await();
                }
                Thread.sleep(1000);
                taskQueue.remove(0);
                isFull.signalAll();
                System.out.println("Consumed, " + ",size:" + taskQueue.size());
            } finally {
                lock.unlock();
            }
        }
    }
}
