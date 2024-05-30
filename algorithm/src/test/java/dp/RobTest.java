package dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class RobTest {
    @Test
    public void test() {
        int res = rob(new int[]{1, 2, 3, 1});
        System.out.println(res);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
