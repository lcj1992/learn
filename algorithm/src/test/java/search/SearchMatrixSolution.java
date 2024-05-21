package search;

/**
 * @author lichuangjian
 * @date 2023/6/20
 */
public class SearchMatrixSolution {


    public static void main(String[] args) {
        SearchMatrixSolution solution = new SearchMatrixSolution();
        int[] a1 = new int[]{1, 3, 5, 7};
        int[] a2 = new int[]{10, 11, 16, 20};
        int[] a3 = new int[]{23, 30, 34, 60};
        int[][] matrix = new int[3][4];
        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;

        boolean result = solution.searchMatrix(matrix, 24);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix[0].length;
        int length = matrix.length;
        int i = 0;
        for (; i < length - 1; i++) {
            if (matrix[i][0] <= target && matrix[i + 1][0] > target) {
                break;
            }
        }
        for (int j = 0; j < width; j++) {
            if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
