package concurrent.comm.produer_consumer_model;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/30
 * Time: 下午11:18
 */
public class BlockingQueueModel implements Model {

    private final BlockingQueue<String> BLOCKING_QUEUE;

    public BlockingQueueModel(int cap) {
        this.BLOCKING_QUEUE = new LinkedBlockingQueue<>(cap);
    }


    @Override
    public void produce() throws InterruptedException {
        String task = UUID.randomUUID().toString();
        BLOCKING_QUEUE.put(task);
        System.out.println("produce task, current size: " + BLOCKING_QUEUE.size());
    }

    @Override
    public void consume() throws InterruptedException {
        BLOCKING_QUEUE.take();
        System.out.println("consume task, current size: " + BLOCKING_QUEUE.size());
    }

}
