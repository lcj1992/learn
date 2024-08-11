package ds.matrix;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/">...</a>
 * <p>
 * 题解：
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/">...</a>
 */
public class SetZeroesTest {

    @Test
    public void test() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        Utils.print(matrix);
    }

    /**
     * 使用一个标记变量，使用原矩阵第一行、第一列作为标记数组
     * 第一列的第一个元素即可以标记第一行是否出现 0
     */
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean flagCol0 = false;
        for (int rowId = 0; rowId < rowLen; rowId++) {
            // 第一列只要有一个元素为0，就将flagCol0置为true
            if (matrix[rowId][0] == 0) {
                flagCol0 = true;
            }
            // 设置第一行，第一列的标记值
            for (int colId = 1; colId < colLen; colId++) {
                if (matrix[rowId][colId] == 0) {
                    matrix[rowId][0] = matrix[0][colId] = 0;
                }
            }
        }
        // 为了防止每一列的第一个元素被提前更新，我们需要从最后一行开始，倒序地处理矩阵元素。
        // 基于标记处理数组
        for (int rowId = rowLen - 1; rowId >= 0; rowId--) {
            for (int colId = 1; colId < colLen; colId++) {
                if (matrix[rowId][0] == 0 || matrix[0][colId] == 0) {
                    matrix[rowId][colId] = 0;
                }
            }
            if (flagCol0) {
                matrix[rowId][0] = 0;
            }
        }
    }

    /**
     * 使用两个标记变量，并复用第一行、第一列元素作为标记数组
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * 使用两个标记数组，记录每行、每列是否存在0
     */
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
