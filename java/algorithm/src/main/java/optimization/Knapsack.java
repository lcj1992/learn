package optimization;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/22
 * Time: 下午12:55
 */
public class Knapsack {

    public static void main(String[] args) {
        int[] weight = {2, 4, 9, 7, 3};  // 物品重量
        int quantity = 5; // 物品个数
        int limitedWeight = 17; // 背包承受的最大重量
        Knapsack test = new Knapsack();
        int knapsack = test.knapsack(weight, quantity, limitedWeight);
        System.out.println(knapsack);
    }

    private int knapsack(int[] weight, int quantity, int limitedWeight) {
        int table[][] = new int[quantity][limitedWeight + 1];

        for (int idx = 0; idx < quantity; idx++) {
            for (int curWeight = 1; curWeight <= limitedWeight; curWeight++) {
                if (idx == 0) {
                    if (weight[idx] <= curWeight) {
                        table[idx][curWeight] = weight[idx];
                    }
                    continue;
                }
                if (weight[idx] > curWeight) {
                    table[idx][curWeight] = table[idx - 1][curWeight];
                } else {
                    int weightWhenPlaced = table[idx - 1][curWeight - weight[idx]] + weight[idx];
                    int weightWhenNotPlaced = table[idx - 1][curWeight];
                    table[idx][curWeight] = Math.max(weightWhenNotPlaced, weightWhenPlaced);
                }
            }
        }
        return table[quantity - 1][limitedWeight];
    }
}
