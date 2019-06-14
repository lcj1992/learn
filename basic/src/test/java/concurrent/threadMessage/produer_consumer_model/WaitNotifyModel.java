package concurrent.threadMessage.produer_consumer_model;

import com.google.common.collect.Lists;
import concurrent.threadMessage.produer_consumer_model.definition.AbstractConsumer;
import concurrent.threadMessage.produer_consumer_model.definition.AbstractProducer;
import concurrent.threadMessage.produer_consumer_model.definition.Model;
import concurrent.threadMessage.produer_consumer_model.definition.Task;
import concurrent.threadMessage.produer_consumer_model.utils.IDGenerator;

import java.util.List;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午8:48
 */
public class WaitNotifyModel implements Model {

    private final Object obj = new Object();
    private final List<Task> queue = Lists.newLinkedList();
    private int capacity;

    WaitNotifyModel(int capacity) {
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
            synchronized (obj) {
                while (queue.size() >= capacity) {
                    obj.wait();
                }
                Task task = new Task(IDGenerator.generateId());
                System.out.println("produce:" + task.getNo());
                queue.add(task);
                obj.notifyAll();
            }
        }
    }

    private class ConsumerImpl extends AbstractConsumer {
        @Override
        public void consume() throws InterruptedException {
            synchronized (obj) {
                while (queue.isEmpty()) {
                    obj.wait();
                }
                Task task = queue.remove(0);
                System.out.println("consume: " + task.getNo());
                obj.notifyAll();
            }
        }
    }
}
