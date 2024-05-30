package simulation;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/">...</a>
 * 旋转图像
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class RotateTest {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++)
            tmp[i] = matrix[i].clone();
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }
}
