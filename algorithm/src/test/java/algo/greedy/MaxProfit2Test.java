package algo.greedy;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">...</a>
 * 买卖股票的最佳时机 II
 * 思路：
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class MaxProfit2Test {

    @Test
    public void test() {
        int res = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
