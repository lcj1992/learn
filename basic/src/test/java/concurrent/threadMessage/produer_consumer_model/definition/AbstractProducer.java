package concurrent.threadMessage.produer_consumer_model.definition;

import concurrent.threadMessage.produer_consumer_model.utils.TimeConsumeSimulator;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/30
 * Time: 下午11:14
 */
public abstract class AbstractProducer implements Producer, Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                produce();
                TimeConsumeSimulator.simulateTimeConsume(1000);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
