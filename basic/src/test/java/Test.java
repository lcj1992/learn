/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/1
 * Time: 上午9:29
 */
public class Test {
    private static String staticString = "hello";
    private static Integer staticInteger = 123;
    private static Long staticLong = 1234L;

    public static void main(String[] args) {
        String aString = "hi";
        Integer aInteger = 12345;
        Long aLong = 123456L;
    }

    public Integer addOne(int i) {
        return i + 1;
    }
}