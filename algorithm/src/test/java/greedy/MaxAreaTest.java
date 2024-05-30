package greedy;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * @author lichuangjian
 * @date 2023/6/28
 */
public class MaxAreaTest {

    @Test
    public void test() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(height);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int l = j - i;
            result = Math.max(result, l * h);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
