package util.concurrent.executor;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleServiceTest {

    @Test
    public void testSchedule() throws InterruptedException {
        long start = System.currentTimeMillis();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.schedule(() -> {
            System.out.println("test schedule just once, cost: " + (System.currentTimeMillis() - start));
        }, 3, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }

    @Test
    public void testScheduleWithFixDelay() throws InterruptedException {
        long start = System.currentTimeMillis();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test schedule with fix delay, cost: " + (System.currentTimeMillis() - start));
        }, 1, 2, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }

    @Test
    public void testScheduleAtFixedRate() throws InterruptedException {
        long start = System.currentTimeMillis();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test schedule at fix rate, cost: " + (System.currentTimeMillis() - start));
        }, 1, 2, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }
}
