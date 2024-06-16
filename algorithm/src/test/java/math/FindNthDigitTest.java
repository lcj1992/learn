package math;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/nth-digit/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class FindNthDigitTest {
    @Test
    public void test() {
        int res = findNthDigit(388);
        System.out.println(res);
    }

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= (int) count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}
