package proxy.staticProxy;


/**
 * Created by lcj on 15-9-13.
 */
public class TestProxy {
    public static void main(String[] args) {
        DailyImpl dailyImpl = new DailyImpl();
        DailyProxy proxy = new DailyProxy(dailyImpl);
        System.out.println("--------eat");
        proxy.eat();
        System.out.println("--------sleep");
        proxy.sleep();
        System.out.println("--------code");
        proxy.code();
    }
}

