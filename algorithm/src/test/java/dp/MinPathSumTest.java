package dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/minimum-path-sum/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class MinPathSumTest {

    @Test
    public void test() {
        int res = minPathSum2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(res);
    }

    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row - 1][column - 1];
        for (int i = 0; i < row; i++) {
            dp[i][0] = grid[i][0];
        }
        for (int j = 0; j < column; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }



    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
