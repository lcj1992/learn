package proxy;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 16/8/20
 * Time: 下午3:24
 */
interface Daily {

    void eat();

    void sleep();

    void code();
}

class DailyImpl implements Daily {

    @Override
    public void eat() {
        System.out.println("eat is necessary ");
    }

    @Override
    public void sleep() {
        System.out.println("sleep is necessary");
    }

    @Override
    public void code() {
        System.out.println("code is necessary");

    }
}

class DailyProxy implements Daily {
    private Daily daily;

    DailyProxy(Daily daily) {
        this.daily = daily;
    }

    public void eat() {
        daily.eat();
        System.out.println("麻烦");
        System.out.println("------------");
    }

    public void sleep() {
        daily.sleep();
        System.out.println("麻烦");
        System.out.println("------------");
    }

    public void code() {
        daily.code();
        System.out.println(" i love it");
        System.out.println("------------");
    }
}

public class StaticProxyTest {

    @Test
    public void staticProxy() {
        Daily daily = new DailyImpl();
        Daily proxy = new DailyProxy(daily);
        proxy.eat();
        proxy.code();
        proxy.sleep();
    }
}
