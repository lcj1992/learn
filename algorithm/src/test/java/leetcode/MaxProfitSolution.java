package leetcode;

/**
 * @author lichuangjian
 * @date 2023/8/15
 */
public class MaxProfitSolution {

    public static void main(String[] args) {
        MaxProfitSolution solution = new MaxProfitSolution();
        int[] prices = {897, 265, 201, 86, 56, 657, 273, 25};
        int result = solution.maxProfit(prices);
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

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
