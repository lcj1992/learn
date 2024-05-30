package dp;

/**
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class RunningSumTest {


    public int[] runningSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }

}
