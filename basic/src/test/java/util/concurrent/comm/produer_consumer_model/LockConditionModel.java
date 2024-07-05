package util.concurrent.comm.produer_consumer_model;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
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
    private final List<String> queue = new LinkedList<>();
    private final int capacity;

    public LockConditionModel(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= capacity) {
                notFull.await();
            }
            queue.add(UUID.randomUUID().toString());
            System.out.println("produce task, current size: " + queue.size());
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            queue.remove(0);
            System.out.println("consume task, current size: " + queue.size());
            notFull.signal();
        } finally {
            lock.unlock();
        }

    }
}
