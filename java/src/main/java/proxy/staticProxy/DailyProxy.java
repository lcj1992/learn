package proxy.staticProxy;

/**
 * Created by lcj on 15-9-13.
 */
public class DailyProxy implements Daily {
    private DailyImpl dailyImpl;


    public DailyProxy(DailyImpl dailyImpl) {
        this.dailyImpl = dailyImpl;
    }


    public void eat() {
        System.out.println("麻烦");
        dailyImpl.eat();
        System.out.println("但是必须");
    }


    public void sleep() {
        System.out.println("麻烦");
        dailyImpl.sleep();
        System.out.println("但是必须");
    }

    public void code() {
        System.out.println(" i love it ");
        dailyImpl.code();
        System.out.println(" i love it");
    }
}
