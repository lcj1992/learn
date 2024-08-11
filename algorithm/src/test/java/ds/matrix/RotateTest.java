package ds.matrix;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/">...</a>
 * 旋转图像
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class RotateTest {

    @Test
    public void test() {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(mat);
        for (int[] ints : mat) {
            Utils.print(ints);
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++) {
            tmp[i] = matrix[i].clone();
        }
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }
}
