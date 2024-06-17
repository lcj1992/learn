package concurrent.comm.produer_consumer_model;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/30
 * Time: 下午11:16
 */
public interface Model {
    void produce() throws InterruptedException;

    void consume() throws InterruptedException;
}
