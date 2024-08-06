package jvm.memTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcj on 15-6-6.
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstPoolOOM {

    @Test
    public void test(){
        List<String> list = new ArrayList<String>();
        int i = 0;

        //从jdk1.7之后开始逐步“去永久代”，所以下四行代码在jdk1.6和1.7具有不同的表现
        //false false
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        //true false
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        // OutOfMemory
        while (true) {
            list.add(String.valueOf(i).intern());
        }
    }
}
