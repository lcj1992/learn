package dp;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class MaxSubArrayTest {


    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
