package greedy;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 搜索二维矩阵
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class SearchMatrixTest {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
