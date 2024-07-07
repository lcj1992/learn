package leetcode;

import common.Utils;
import org.junit.Test;

import java.util.Arrays;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/4/20
 * Time: 上午10:42
 */
public class TwoSumTest {

    @Test
    public void testTwoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSumTest twoSum = new TwoSumTest();
        int[] res = twoSum.twoSum(nums, target);
        Utils.printArray(res);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new RuntimeException("不匹配");
    }
}
