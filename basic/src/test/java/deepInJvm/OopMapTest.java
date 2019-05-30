package deepInJvm;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/28
 * Time: 上午9:35
 */
public class OopMapTest {
    public int foo(int a) {
        Object obj = new Object();
        while (a > 0) {
            a--;
        }
        return a;
    }

    public static void main(String[] args) {
        new OopMapTest().foo(10);
    }

}
