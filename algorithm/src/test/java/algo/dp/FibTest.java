package algo.dp;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/fibonacci-number/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class FibTest {

    @Test
    public void test() {
        int res = fib(20);
        System.out.println(res);
    }

    /**
     * 动态规划简化版
     * 空间复杂度O(1)
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 动态规划
     * 状态转移方程：f(n) = f(n-1)+ f(n-2)
     * 空间复杂度O(n)
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
