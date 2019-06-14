package concurrent.threadMessage.produer_consumer_model;

import concurrent.threadMessage.produer_consumer_model.definition.Model;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/30
 * Time: 下午11:26
 */
public class ProducerConsumerModelTest {

    @Test
    public void testBlockingQueue() throws Exception {
        BlockingQueueModel model = new BlockingQueueModel(3);
        simulateProduceConsume(model);
    }

    @Test
    public void testLockCondition() throws Exception {
        LockConditionModel model = new LockConditionModel(3);
        simulateProduceConsume(model);
    }

    @Test
    public void testWaitNotify() throws Exception {
        WaitNotifyModel model = new WaitNotifyModel(3);
        simulateProduceConsume(model);
    }

    private void simulateProduceConsume(Model model) throws InterruptedException {
        Runnable producer = model.newProducer();
        Runnable consumer = model.newConsumer();
        for (int i = 0; i < 2; i++) {
            new Thread(producer).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(consumer).start();
        }
        Thread.sleep(10000);
    }
}
