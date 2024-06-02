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

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int i;
        for (i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[i - 1];
    }

    public int climbStairs(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n - 1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

}
