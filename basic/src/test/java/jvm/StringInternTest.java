package jvm;

import org.junit.Test;

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
}
