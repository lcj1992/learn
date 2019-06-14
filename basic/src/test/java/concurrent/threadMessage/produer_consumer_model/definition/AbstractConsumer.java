package concurrent.threadMessage.produer_consumer_model.definition;

import concurrent.threadMessage.produer_consumer_model.utils.TimeConsumeSimulator;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/30
 * Time: 下午11:16
 */
public abstract class AbstractConsumer implements Consumer, Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                consume();
                TimeConsumeSimulator.simulateTimeConsume(1000, 500);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
