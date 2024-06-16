package math;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/integer-break/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class IntegerBreakTest {

    @Test
    public void test() {
        int res = integerBreak(10);
        System.out.println(res);
    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

}
