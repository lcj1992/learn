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
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            System.out.println(currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        Thread.sleep(1000L);
        System.out.println(currentThread().getName());
        System.out.println(Thread.activeCount());

        Thread thread1 = new Thread(() -> System.out.println("hehe"));
        thread1.start();
        System.out.println(Thread.activeCount());
        System.out.println("end end!");
        System.out.println(System.currentTimeMillis() - start);
        thread.join();
        System.out.println(System.currentTimeMillis() - start);


    }
}
