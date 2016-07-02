package test;

/**
 * Created by chuangjian.li
 * 16/3/23
 */
public class WaitSleepTest {

    private static volatile int counter = 0;

    private synchronized void count() throws InterruptedException {
        counter ++;
        wait(1);
    }

    public static void main(String[] args) throws InterruptedException {

        WaitSleepTest waitSleepTest  = new WaitSleepTest();
        waitSleepTest.count();
        System.out.println(counter);
    }


}
