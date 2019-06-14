package concurrent.alibaba;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午10:23
 */
public abstract class PrinterRunnable implements PrintAble, Runnable {
    private String name;

    PrinterRunnable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (true) {
            print();
        }
    }
}
