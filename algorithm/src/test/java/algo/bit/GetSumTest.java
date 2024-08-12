package algo.bit;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/sum-of-two-integers/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 * today
 **/
public class GetSumTest {

    @Test
    public void test() {
        int res = getSum(10, 12);
        System.out.println(res);
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
