package concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * Desc: Semaphore 经典的信号量,通过计数器控制对共享资源的访问
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/21
 * Time: 上午11:30
 */

class Person extends Thread {
    private Semaphore semaphore;

    public Person(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(getName() + " is waiting ...");
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(getName() + " is done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

public class SemaphoreTest {

    @Test
    public void test() throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        Person p1 = new Person("A", semaphore);
        p1.start();
        Person p2 = new Person("B", semaphore);
        p2.start();
        Person p3 = new Person("C", semaphore);
        p3.start();
        Thread.sleep(20000);
    }

}
