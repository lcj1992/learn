package deepInJvm;

import static java.lang.Thread.currentThread;

/**
 * Created by chuangjian.li
 * 16/3/11
 */
public class StringHolder {

    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("heheda");
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(currentThread().getName());
                throw new RuntimeException("hahaha");
            }
        };
        thread.start();

        Thread.sleep(3000L);
        System.out.println(currentThread().getName());
        System.out.println(Thread.activeCount());

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("hehe");
            }
        };
        thread1.start();
        System.out.println(Thread.activeCount());
        System.out.println("end end!");
    }
}
