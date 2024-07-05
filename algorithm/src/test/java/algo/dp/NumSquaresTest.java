package algo.dp;

import org.junit.Test;

/**
 * 完全平方数
 * <a href="https://leetcode.cn/problems/perfect-squares/"/>
 *
 * @author foolchild
 * @date 2024-05-20
 */

public class NumSquaresTest {

    @Test
    public void test() {
        int i = numSquares(12);
        System.out.println(i);
    }

    public int numSquares(int n) {
        // 状态，数组下标为当前的值，值为此时，最小的结果
        int[] dp = new int[n + 1];
        int min;
        // 初始化状态
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            min = Integer.MAX_VALUE;
            // 状态转移方程
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - j * j], min);
            }
            dp[i] = min + 1;
        }
        // 最终解
        return dp[n];
    }

}
