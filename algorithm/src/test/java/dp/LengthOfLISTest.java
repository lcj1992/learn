package dp;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/"/>
 * 最长递增子序列
 * 状态转移方程：dp[i]=max(dp[j])+1，其中0≤j<i且num[j]<num[i]
 *
 * @author lichuangjian
 * @date 2023/6/28
 */
public class LengthOfLISTest {

    public static void main(String[] args) {
        LengthOfLISTest solution = new LengthOfLISTest();
        int[] nums = new int[]{5, 7, -24, 12, 13, 2, 3, 12, 5, 6, 35};
        int i = solution.lengthOfLIS(nums);
        System.out.println(i);
    }

    // 1、确认是否存在最优子结构
    // 2、确认状态方程是啥
    // 3、确认状态如何保存
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
