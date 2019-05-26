import org.junit.Test;

import java.util.Arrays;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/4/20
 * Time: 上午10:42
 */
public class TwoSum {

    @Test
    public void testTwoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, target);
        Arrays.stream(ints).forEach(System.out::print);
    }

    public int[] twoSum(int[] nums, int target) {

        int[] results = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    results[0] = i;
                    results[1] = j;
                    return results;
                }
            }
        }
        throw new RuntimeException("不匹配");
    }
}
