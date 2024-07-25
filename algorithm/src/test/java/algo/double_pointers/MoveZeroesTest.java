package algo.double_pointers;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">...</a>
 */
public class MoveZeroesTest {

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        Utils.print(nums);
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                Utils.swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
}
