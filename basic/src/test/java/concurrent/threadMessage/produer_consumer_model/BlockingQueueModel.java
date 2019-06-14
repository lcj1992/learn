package concurrent.threadMessage.produer_consumer_model;

import concurrent.threadMessage.produer_consumer_model.definition.AbstractConsumer;
import concurrent.threadMessage.produer_consumer_model.definition.AbstractProducer;
import concurrent.threadMessage.produer_consumer_model.definition.Model;
import concurrent.threadMessage.produer_consumer_model.definition.Task;
import concurrent.threadMessage.produer_consumer_model.utils.IDGenerator;

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

    private final BlockingQueue<Task> BLOCKING_QUEUE;

    BlockingQueueModel(int cap) {
        this.BLOCKING_QUEUE = new LinkedBlockingQueue<>(cap);
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
            Task task = new Task(IDGenerator.generateId());
            System.out.println("produce: " + task.no);
            BLOCKING_QUEUE.put(task);
        }
    }

    private class ConsumerImpl extends AbstractConsumer {
        @Override
        public void consume() throws InterruptedException {
            Task task = BLOCKING_QUEUE.take();
            System.out.println("consume: " + task.no);
        }
    }
}
