package algo.search;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">...</a>
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 解题思路：
 * 1. 二分查找的变种
 */
public class SearchRangeTest {

    @Test
    public void testSearchRange() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10};
        int[] res = searchRange(nums, 8);
        Utils.printArray(res);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int lowBound = searchLowBound(nums, target);
        int upperBound = searchUpperBound(nums, target);
        return new int[]{lowBound, upperBound};
    }


    public int searchLowBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int res = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int searchUpperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
