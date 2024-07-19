package algo.search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/search-a-2d-matrix/">...</a>
 * 描述：搜索二维矩阵
 * 思路：
 * 1. 先在一维上查找，可以暴力查找，也可以二分查找
 * 2. 再在另一维上查找
 *
 * @author lichuangjian
 * @date 2023/6/20
 */
public class SearchMatrixTest {


    @Test
    public void test() {
        int[] a1 = new int[]{1, 3, 5, 7};
        int[] a2 = new int[]{10, 11, 16, 20};
        int[] a3 = new int[]{23, 30, 34, 60};
        int[][] matrix = new int[3][4];
        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;

        boolean result = searchMatrix(matrix, 24);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowId = searchRow(matrix, target);
        if (rowId < 0) {
            return false;
        }
        return searchColumn(matrix[rowId], target);
    }

    private int searchRow(int[][] matrix, int target) {
        int low = -1;
        int high = matrix.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean searchColumn(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
