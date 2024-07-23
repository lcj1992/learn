package util;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    @Test
    public void test() throws InterruptedException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // do something
                System.out.println("schedule time: " + System.currentTimeMillis());
            }
        }, 1000, 1000);  // 1s 后调度一个周期为 1s 的定时任务
        Thread.sleep(10000);
    }
}
