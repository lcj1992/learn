package deepInJvm;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by chuangjian.li
 * 16/3/11
 */
public class ManyInstancesTest {


    static List list = Lists.newArrayList();


    public static void main(String[] args) throws InterruptedException {
        String a = "hello";

        for (int i = 0; i < 100000; i++) {
            StringHolder test = new StringHolder();
            test.setS(a + 1);
            list.add(test);
            System.out.println(test.getS());
        }
        Thread.sleep(1000000);
    }
}
