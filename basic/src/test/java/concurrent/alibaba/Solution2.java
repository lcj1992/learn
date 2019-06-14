package concurrent.alibaba;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午10:22
 */
public class Solution2 {
    @Test
    public void test() throws InterruptedException {
        Printer printer =new Printer();
        Thread thread1 = new Thread(printer.newPrintRunnable("printer1"));
        thread1.start();
        Thread thread2 = new Thread(printer.newPrintRunnable("printer2"));
        thread2.start();
        System.out.println("hello world");
        Thread.sleep(100000);
    }
}
