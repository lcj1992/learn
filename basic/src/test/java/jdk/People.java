package jdk;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by chuangjian.li
 * 16/3/12
 */
public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        //类型检查
        //...
        return this.name.equals(((People) obj).name) && this.age == ((People) obj).age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 37 + age;
    }

    public static void main(String[] args) {
//        People p1 = new People("foolchild", 24);
//        System.out.println(p1.hashCode());
//
//        Map<People, Integer> hashMap = new HashMap<People, Integer>();
//        hashMap.put(p1, 1);
//
//        System.out.println(hashMap.get(new People("foolchild", 24)));

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("i am alive!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("main end");
    }
}