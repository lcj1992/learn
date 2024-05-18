package linear.array;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void testGenerateMatrix() {
        int[][] matrix = generateMatrix(5);
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
        step = n - 2;
        int startIndex = 1;
        for (; step >= 0; step--, sum++) {
            for (int i = 0; i <= step; i++) {
                if (step % 2 == 0) {
                    results[sum - i - startIndex][startIndex + i] = num++;
                } else {
                    results[startIndex + i][sum - i - startIndex] = num++;
                }
            }
            startIndex++;
        }
        return results;
    }
}

