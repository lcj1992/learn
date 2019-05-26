package deepInJvm;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/25
 * Time: 上午8:58
 */
public class StringInternTest {


    private static String abc = "abcdefg";

    @Test
    public void test() {
        String val1 = "abcdefg";
        System.out.println(val1 == this.abc);

        String val2 = "a" + "bcdedg";
        String val3 = "a" + new String("bcdedg");
        String val4 = new String("abcdefg");

        System.out.println(val2 == this.abc);
        System.out.println(val3 == this.abc);
        System.out.println(val3 == val4);

        String val5 = val3.intern();
        System.out.println(val5 == this.abc);
        System.out.println(val5 == val3);
        System.out.println((val1.intern() == val1) ? "val1 == val.intern()" : "val1 != val.intern()");
    }


    @Test
    public void testStringIntern() throws InterruptedException {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 100000000; i++) {
            list.add(("lichuangjian" + i).intern());
            if (i % 100 == 0)
                Thread.sleep(1);
        }
        System.out.println(list.toString());
    }

    @Test
    public void testString() throws InterruptedException {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 100000000; i++) {
            list.add(("lichuangjian" + i));
            if (i % 100 == 0)
                Thread.sleep(1);
        }
        System.out.println(list.toString());
    }
}
