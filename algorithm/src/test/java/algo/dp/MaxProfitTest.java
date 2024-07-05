package algo.dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">...</a>
 * @author lichuangjian
 * @date 2023/8/15
 */
public class MaxProfitTest {

    @Test
    public void test() {
        int[] prices = {897, 265, 201, 86, 56, 657, 273, 25};
        int result = maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划
     */
    public int maxProfit3(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }


    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
