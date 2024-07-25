package algo.dp;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/running-sum-of-1d-array/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class RunningSumTest {


    @Test
    public void test() {
        int[] res = runningSum(new int[]{1, 2, 3, 4, 5});
        Utils.print(res);
    }

    public int[] runningSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }

}
