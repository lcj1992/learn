package netty;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NettyHashedWheelTimerTest {

    @Test
    public void test() throws InterruptedException {
        Timer timer = new HashedWheelTimer();
        Timeout timeout1 = timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) {
                System.out.println("timeout1: " + new Date());
            }
        }, 10, TimeUnit.SECONDS);

        if (!timeout1.isExpired()) {
            timeout1.cancel();
        }
        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws InterruptedException {
                System.out.println("timeout2: " + new Date());
                Thread.sleep(5000);
            }
        }, 1, TimeUnit.SECONDS);

        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) {
                System.out.println("timeout3: " + new Date());
            }
        }, 3, TimeUnit.SECONDS);
        Thread.sleep(11000);
    }

}