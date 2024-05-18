package leetcode;

/**
 * @author lichuangjian
 * @date 2023/6/27
 */
public class Knapsack01Solution {

    public static void main(String[] args) {
        Knapsack01Solution solution = new Knapsack01Solution();
        int[] w = {1, 2, 5, 6, 7}; // 商品的重量
        int[] v = {1, 6, 18, 22, 28};  //商品的价值
        int W = 12; // 背包的承重
        solution.knapsack01(w, v, W);
    }

    public void knapsack01(int[] w, int[] v, int W) {
        int[][] result = new int[w.length + 1][W + 1];
        int i, j = 1;
        // 逐个遍历每个商品
        for (i = 1; i <= w.length; i++) {
            // 求出从 1 到 W 各个承重对应的最大收益
            for (j = 1; j <= W; j++) {
                // 如果背包承重小于商品总重量，则该商品无法放入背包，收益不变
                if (j < w[i - 1]) {
                    result[i][j] = result[i - 1][j];
                    continue;
                }
                // 比较装入该商品和不装该商品，哪种情况获得的收益更大，记录最大收益值
                result[i][j] = Math.max(result[i - 1][j], (v[i - 1] + result[i - 1][j - w[i - 1]]));
            }
        }
        System.out.println(j - 1);
        System.out.println(result[i - 1][j - 1]);
    }
}
