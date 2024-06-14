package simulation;

import org.junit.Test;

/**
 * @author foolchid
 * @date 2024/5/28
 **/
public class GenerateMatrix2Test {

    @Test
    public void testGenerateMatrix() {
        int[][] matrix = generateMatrix(6);
        for (int[] array : matrix) {
            for (int item : array) {
                System.out.print(item + (item >= 10 ? " " : "  "));
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        int num = 1; // 从1开始的连续整数，游标
        int step = 0; // 一次打印几个数，每次循环结束+1
        int sum = 0; // 坐标和，每次循环结束+1
        for (; step < n; step++, sum++) {
            for (int i = 0; i <= step; i++) {
                if (step % 2 == 0) {
                    results[sum - i][i] = num++;
                } else {
                    results[i][sum - i] = num++;
                }
            }
        }
        for (; step >= 0; step--, sum++) {
            for (int i = 1; i < step; i++) {
                if (step % 2 == 0) {
                    results[n - i][sum - n + i] = num++;
                } else {
                    results[sum - n + i][n - i] = num++;
                }
            }
        }
        return results;
    }

}
