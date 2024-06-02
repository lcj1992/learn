package greedy;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 搜索二维矩阵
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class SearchMatrixTest {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean res = searchMatrix(matrix, 12);
        System.out.println(res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
