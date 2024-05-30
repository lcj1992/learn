package dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">...</a>
 * 买卖股票的最佳时机 II
 * 思路：
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class MaxProfitDpTest {

    @Test
    public void test() {

        int res = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
