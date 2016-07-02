package jdk.proxy.staticProxy;

/**
 * Created by lcj on 15-9-13.
 */
public class DailyImpl implements Daily {

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
