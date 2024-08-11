package algo.search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/single-element-in-a-sorted-array/">...</a>
 */
public class SingleNonDuplicateTest {

    @Test
    public void test() {
        int res = singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8});
        System.out.println(res);
    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            mid -= mid & 1;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
