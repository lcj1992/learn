package algo.double_pointers;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/">...</a>
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
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            res = Math.max(res, l * h);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
