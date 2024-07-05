package algo.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/binary-search/">...</a>
 * 二分查找
 * 1. 随机，[0, length-1], right = mid -1, left = mid + 1
 * 2. 下界，[0, length), right = mid, left = mid + 1
 * 3. 上界, [0, length], right = mid - 1, left = mid + 1
 */
public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int search = search(nums, 5);
        Assert.assertEquals(search, 4);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }
            if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
