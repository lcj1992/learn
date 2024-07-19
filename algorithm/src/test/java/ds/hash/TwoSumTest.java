package ds.hash;

import common.Utils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
