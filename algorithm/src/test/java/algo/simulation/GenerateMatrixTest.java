package algo.simulation;

import common.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class GenerateMatrixTest {


    @Test
    public void test() {
        int[][] ints = generateMatrix(5);
        Arrays.stream(ints).forEach(Utils::print);
    }


    /**
     * 思路：
     * 1. 记录上、下、左、右的边界，并调整
     * 2. 依次向右、向下、向左、向上
     * 3. 迭代的终止条件，num < n * n
     */
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int[][] mat = new int[n][n];
        int num = 1;
        int tar = n * n;
        while (num <= tar) {
            // 向右：left to right.
            for (int i = left; i <= right; i++) {
                mat[top][i] = num++;
            }
            top++;
            // 向下：top to bottom.
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num++;
            }
            right--;
            // 向左：right to left.
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = num++;
            }
            bottom--;
            // 向上：bottom to top.
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = num++;
            }
            left++;
        }
        return mat;
    }

    public int[][] generateMatrix2(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        int[][] res = new int[n][n];
        while (left <= right && top <= bottom) {
            // 向右
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            // 向下
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            // 向左
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = num++;
                }
                bottom--;
            }
            // 向上
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = num++;
                }
                left++;
            }
        }
        return res;
    }

}
