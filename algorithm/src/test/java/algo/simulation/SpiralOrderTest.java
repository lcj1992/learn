package algo.simulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">...</a>
 * 螺旋遍历二维数组
 * 思路：
 * 1. 向右、向下、向左、向上，分别调整top、left、bottom、right坐标
 */
public class SpiralOrderTest {

    @Test
    public void test() {

        int[][] matrix = new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
        List<Integer> integers = spiralOrder(matrix);
        System.out.println(integers);
    }

    /**
     * 思路：
     * 1. 记录上、下、左、右的边界，并调整
     * 2. 依次向右、向下、向左、向上
     * 3. 迭代的终止条件，top>bottom || left > right
     */
    public List<Integer> spiralOrder(int[][] matrix) {
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
}
