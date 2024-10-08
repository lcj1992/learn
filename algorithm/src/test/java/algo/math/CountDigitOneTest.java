package algo.math;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/number-of-digit-one/">...</a>
 * 数字 1 的个数
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class CountDigitOneTest {

    @Test
    public void test() {
        int res = countDigitOne(13);
        System.out.println(res);
    }

    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

}
