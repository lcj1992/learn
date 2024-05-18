package linear.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayTest {

    @Test
    public void testPrintMatrix() {

        int[][] matrix = new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};

        List<Integer> integers = printMatrix(matrix);
        System.out.println(integers);
    }

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

    public List<Integer> printMatrix(int[][] matrix) {
        if (Objects.isNull(matrix) || Objects.isNull(matrix[0])) {
            return new ArrayList<>();
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> results = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // 向右
            for (int i = left; i <= right; i++) {
                results.add(matrix[top][i]);
            }
            top++;
            // 向下
            for (int i = top; i <= bottom; i++) {
                results.add(matrix[i][right]);
            }
            right--;
            // 向左
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    results.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 向上
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    results.add(matrix[i][left]);
                }
                left++;
            }
        }
        return results;
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

