package concurrent.comm.produer_consumer_model;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.UUID;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午8:48
 */
public class WaitNotifyModel implements Model {

    private final Object obj = new Object();
    private final List<String> queue = Lists.newLinkedList();
    private final int capacity;

    public WaitNotifyModel(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public void produce() throws InterruptedException {
        synchronized (obj) {
            while (queue.size() >= capacity) {
                obj.wait();
            }
            queue.add(UUID.randomUUID().toString());
            System.out.println("produce task, current size: " + queue.size());
            obj.notifyAll();
        }
    }

    @Override
    public void consume() throws InterruptedException {
        synchronized (obj) {
            while (queue.isEmpty()) {
                obj.wait();
            }
            queue.remove(0);
            System.out.println("consume task, current size: " + queue.size());
            obj.notifyAll();
        }
    }
}
