package algo.greedy;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/jump-game/">跳跃游戏</a>
 */
public class CanJumpTest {

    @Test
    public void test() {
        boolean res = canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(res);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
