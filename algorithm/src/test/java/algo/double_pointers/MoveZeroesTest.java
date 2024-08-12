package algo.double_pointers;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">...</a>
 * today
 */
public class MoveZeroesTest {

    @Test
    public void test() {
        int[] nums = {1, 3, 0, 0, 12};
        moveZeroes(nums);
        Utils.print(nums);
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                Utils.swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
}
