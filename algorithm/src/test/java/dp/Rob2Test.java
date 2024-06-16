package dp;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/house-robber-ii/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class Rob2Test {

    @Test
    public void test() {
        int res = rob(new int[]{2, 3, 2});
        System.out.println(res);
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
