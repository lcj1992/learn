package dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/">...</a>
 * @author lichuangjian
 * @date 2023/8/9
 */
public class ClimbStairsTest {

    @Test
    public void test() {
        int i = climbStairs(5);
        System.out.println(i);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        int i;
        for (i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[i - 1];
    }
}
