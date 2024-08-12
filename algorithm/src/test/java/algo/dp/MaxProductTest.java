package algo.dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-subarray/">...</a>
 * today
 */
public class MaxProductTest {

    @Test
    public void test() {
        int res = maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(res);
    }

    public int maxProduct(int[] nums) {
        long maxDp = nums[0];
        long minDp = nums[0];
        int res = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            long max = maxDp;
            long min = minDp;
            maxDp = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            minDp = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
            if (minDp < -1 << 31) {
                minDp = nums[i];
            }
            res = Math.max((int) maxDp, res);
        }
        return res;
    }

}

