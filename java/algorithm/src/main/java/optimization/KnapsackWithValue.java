package optimization;

/**
 * Desc: 背包问题
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/22
 * Time: 下午10:35
 */
public class KnapsackWithValue {

    public static void main(String[] args) {
        int quantity = 5;//物品个数
        int limitedWeight = 10; // 背包容量
        int[] values = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weights = {0, 2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(getMaxValue(weights, values, limitedWeight, quantity));
    }

    private static int getMaxValue(int[] weights, int[] values, int limitedWeight, int quantity) {
        int[][] table = new int[quantity + 1][limitedWeight + 1];

        // 物品
        for (int currentQuantity = 1; currentQuantity <= quantity; currentQuantity++) {
            //背包大小
            for (int currentLimitedWeight = 1; currentLimitedWeight <= limitedWeight; currentLimitedWeight++) {

                if (weights[currentQuantity] > currentLimitedWeight) {
                    // 当前物品的重量比当前背包容量大,装不下
                    table[currentQuantity][currentLimitedWeight] = table[currentQuantity - 1][currentLimitedWeight];
                } else {
                    // 当前物品的重量小于等于当前背包容量,装得下，装还是不装
                    // Max{装物品的价值， 不装物品的价值}
                    int valueWhenPlaced = table[currentQuantity - 1][currentLimitedWeight - weights[currentQuantity]] + values[currentQuantity];
                    int valueWhenNotPlaced = table[currentQuantity - 1][currentLimitedWeight];
                    table[currentQuantity][currentLimitedWeight] = Math.max(valueWhenPlaced, valueWhenNotPlaced);
                }
            }
        }
        return table[quantity][limitedWeight];
    }
}

