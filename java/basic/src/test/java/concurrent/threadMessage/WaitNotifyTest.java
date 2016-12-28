package concurrent.threadMessage;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Desc: 线程间通信
 * 1.object#wait()和object#notify()
 * 2.LockSupport.park()和LockSupport#unpark()
 * 3.Condition.await()和Condition.signal()
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/23
 * Time: 下午7:55
 */
public class WaitNotifyTest {

    // 1.当队列满了,生产者线程wait。(别生产了,等会消费者)
    // 2.当队列空了,消费者线程wait。(别消费了,等会生产者)
    // 3.队列不满也不空的情况下,生产者消费者争taskQueue的锁。

    // wait和notify
    @Test
    public void waitNotifyTest() throws InterruptedException {
        List<Integer> taskQueue = Lists.newArrayList();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        tProducer.start();
        tConsumer.start();
        Thread.sleep(100000);
    }

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
            synchronized (taskQueue) {
                while (taskQueue.size() >= MAX_CAPACITY) {
                    System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                    // 当前线程释放对taskQueue的monitor(锁),
                    // 直到别的线程(必须是别的,参见 WaitNotifyTest#notifyMustOtherThread)调用taskQueue.notify()或者notifyAll(),该线程才可能恢复到taskQueue的monitor
                    taskQueue.wait();
                }

                Thread.sleep(1000);
                taskQueue.add(i);
                System.out.println("Produced, " + "size:" + taskQueue.size());
                taskQueue.notifyAll();
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
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                    taskQueue.wait();
                }

                Thread.sleep(1000);
                taskQueue.remove(0);
                System.out.println("Consumed, " + ",size:" + taskQueue.size());
                taskQueue.notifyAll();
            }
        }
    }

    @Test
    public void waitAndNotify() throws InterruptedException {
        Object object = new Object();
        long start = System.currentTimeMillis();
        new Thread(() -> {
            try {
                synchronized (object) {
                    Thread.sleep(3000);
                    object.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        synchronized (object) {
            object.wait();
        }
        System.out.println("cost time " + (System.currentTimeMillis() - start));
    }

    @Test
    public void notifyMustOtherThread() throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            object.wait();
            object.notify();
        }
        // 这里一直打印不了hehe,线程阻塞了。
        System.out.println("hehe");
    }

}
