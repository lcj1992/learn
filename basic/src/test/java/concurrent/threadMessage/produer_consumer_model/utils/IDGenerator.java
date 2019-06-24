package concurrent.threadMessage.produer_consumer_model.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午8:17
 */
public class IDGenerator {
    private static final AtomicInteger ID = new AtomicInteger(1);

    public static int generateId() {
        return ID.getAndIncrement();
    }
}
