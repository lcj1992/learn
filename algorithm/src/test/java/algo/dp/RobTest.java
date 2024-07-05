package algo.dp;

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
        int res = rob2(new int[]{1, 2, 3, 1});
        System.out.println(res);
    }

    /**
     * 状态转移方程：
     * dp[i] = max(dp[i-2] + nums[i-1], dp[i-1])
     * dp[i]代表当抢了i家后的最大金额（数组下标+1）
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }

    /**
     * 使用滚动数组，降低空间复杂度
     * 计算抢了i家的状态，只需要i-1和i-2时的状态
     */
    public int rob2(int[] nums) {
        int first = 0;
        int second = nums[0];
        int res = second;
        for (int i = 2; i <= nums.length; i++) {
            res = Math.max(first + nums[i - 1], second);
            first = second;
            second = res;
        }
        return res;
    }

}
