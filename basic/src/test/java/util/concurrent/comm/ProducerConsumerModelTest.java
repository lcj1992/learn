package util.concurrent.comm;

import util.concurrent.comm.produer_consumer_model.BlockingQueueModel;
import util.concurrent.comm.produer_consumer_model.LockConditionModel;
import util.concurrent.comm.produer_consumer_model.Model;
import util.concurrent.comm.produer_consumer_model.WaitNotifyModel;
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
        BlockingQueueModel model = new BlockingQueueModel(5);
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
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    model.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    model.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        Thread.sleep(10000);
    }
}
