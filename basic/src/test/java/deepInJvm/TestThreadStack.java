package deepInJvm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/27
 * Time: 上午9:26
 */
public class TestThreadStack {

    @Test
    public void test() {
        Person lcj = new Person(27, "lcj");
        System.out.println(lcj);
        Thread thread = new Thread(() -> {
            Person sh = new Person(27, "sh");
            System.out.println(sh);
        });
        thread.start();
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class Person {

        private int age;

        private String name;
    }
}
