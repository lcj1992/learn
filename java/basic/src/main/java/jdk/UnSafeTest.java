package jdk;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Created by chuangjian.li
 * 16/3/22
 */
public class UnSafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        //这个方法创建一个player类没有任何的初始化
        Player p = (Player) unsafe.allocateInstance(Player.class);
        System.out.println(p.getAge());

        p.setAge(45);
        System.out.println(p.getAge());
    }


    class Player {
        private int age = 12;

        private Player() {
            this.age = 50;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
