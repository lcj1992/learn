package algo.dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/">...</a>
 */
public class CanPartitionTest {

    @Test
    public void test() {
        boolean res = canPartition(new int[]{1, 2, 3, 6});
        System.out.println(res);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}
