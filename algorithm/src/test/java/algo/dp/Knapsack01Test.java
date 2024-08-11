package algo.dp;

import org.junit.Test;

/**
 * 01背包问题
 * 解题思路
 * 1. 状态转移方程：
 * 1.1 dp[i][j] = Math.max(dp[i - 1][j], (v[i - 1] + dp[i - 1][j - w[i - 1]]));
 * 1.2 dp[i][j] = dp[i-1][j]
 * 题解
 * <a href="https://www.bilibili.com/video/BV1kp4y1e794/">...</a>
 *
 * @author lichuangjian
 * @date 2023/6/27
 */
public class Knapsack01Test {

    @Test
    public void test() {
        int[] w = {1, 2, 5, 6, 7}; // 商品的重量
        int[] v = {1, 6, 18, 22, 28};  //商品的价值
        int W = 12; // 背包的承重
        int result = knapsack01(w, v, W);
        System.out.println(result);
        result = knapsack012(w, v, W);
        System.out.println(result);
    }

    public int knapsack01(int[] w, int[] v, int W) {
        int[][] dp = new int[w.length + 1][W + 1];
        // 逐个遍历每个商品
        for (int i = 1; i <= w.length; i++) {
            // 求出从 1 到 W 各个承重对应的最大收益
            for (int j = 1; j <= W; j++) {
                // 如果背包承重小于商品总重量，则该商品无法放入背包，收益不变
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 比较装入该商品和不装该商品，哪种情况获得的收益更大，记录最大收益值
                    dp[i][j] = Math.max(dp[i - 1][j], (v[i - 1] + dp[i - 1][j - w[i - 1]]));
                }
            }
        }
        return dp[w.length][W];
    }

    public int knapsack012(int[] w, int[] v, int W) {
        int[] dp = new int[W + 1];
        // 逐个遍历每个商品
        for (int i = 1; i <= w.length; i++) {
            // 求出从 1 到 W 各个承重对应的最大收益
            for (int j = W; j >= w[i - 1]; j--) {
                // 比较装入该商品和不装该商品，哪种情况获得的收益更大，记录最大收益值
                dp[j] = Math.max(dp[j], (v[i - 1] + dp[j - w[i - 1]]));
            }
        }
        return dp[W];
    }
}
