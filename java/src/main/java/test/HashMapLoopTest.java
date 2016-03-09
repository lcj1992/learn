package test;

import java.util.HashMap;

/**
 * Created by chuangjian.li
 * 16/3/8
 */
public class HashMapLoopTest {

    private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2,0.75f);
    public static void main(String[] args) {
        map.put(5, 55);

        new Thread("Thread1") {
            public void run() {
                map.put(7, 77);
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, 33);
                System.out.println(map);
            }
        }.start();

    }
}
