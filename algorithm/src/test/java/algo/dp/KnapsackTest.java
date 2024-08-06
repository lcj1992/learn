package algo.dp;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/22
 * Time: 下午12:55
 */
public class KnapsackTest {

    @Test
    public void test() {
        int[] weight = {2, 4, 9, 7, 3};  // 物品重量
        int quantity = 5; // 物品个数
        int limitedWeight = 17; // 背包承受的最大重量
        int knapsack = knapsack(weight, quantity, limitedWeight);
        System.out.println(knapsack);
    }

    private int knapsack(int[] weight, int quantity, int limitedWeight) {
        int[][] dp = new int[quantity][limitedWeight + 1];

        for (int idx = 0; idx < quantity; idx++) {
            for (int curWeight = 1; curWeight <= limitedWeight; curWeight++) {
                if (idx == 0) {
                    if (weight[idx] <= curWeight) {
                        dp[idx][curWeight] = weight[idx];
                    }
                    continue;
                }
                if (weight[idx] > curWeight) {
                    dp[idx][curWeight] = dp[idx - 1][curWeight];
                } else {
                    int weightWhenPlaced = dp[idx - 1][curWeight - weight[idx]] + weight[idx];
                    int weightWhenNotPlaced = dp[idx - 1][curWeight];
                    dp[idx][curWeight] = Math.max(weightWhenNotPlaced, weightWhenPlaced);
                }
            }
        }
        return dp[quantity - 1][limitedWeight];
    }
}
