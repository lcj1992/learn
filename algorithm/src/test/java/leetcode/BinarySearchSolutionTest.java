package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchSolutionTest {
    @Test
    public void testBinarySearch() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int search = search(nums, 5);
        Assert.assertEquals(search, 4);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
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
