package concurrent.threadMessage.produer_consumer_model;

import concurrent.threadMessage.produer_consumer_model.definition.AbstractConsumer;
import concurrent.threadMessage.produer_consumer_model.definition.AbstractProducer;
import concurrent.threadMessage.produer_consumer_model.definition.Model;
import concurrent.threadMessage.produer_consumer_model.definition.Task;
import concurrent.threadMessage.produer_consumer_model.utils.IDGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午6:52
 */
public class LockConditionModel implements Model {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final List<Task> queue = new LinkedList<>();
    private final int capacity;

    LockConditionModel(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Runnable newProducer() {
        return new ProducerImpl();
    }

    @Override
    public Runnable newConsumer() {
        return new ConsumerImpl();
    }

    private class ProducerImpl extends AbstractProducer {
        @Override
        public void produce() throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() >= capacity) {
                    notFull.await();
                }
                Task task = new Task(IDGenerator.generateId());
                System.out.println("produce: " + task.no);
                queue.add(task);
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    private class ConsumerImpl extends AbstractConsumer {
        @Override
        public void consume() throws InterruptedException {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    notEmpty.await();
                }
                Task task = queue.remove(0);
                System.out.println("consume: " + task.no);
                notFull.signal();
            } finally {
                lock.unlock();
            }

        }
    }
}
