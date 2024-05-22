package search;

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
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 7);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                int startIndex = mid;
                int endIndex = mid;
                while (nums[startIndex] == nums[mid]) {
                    startIndex--;
                    if (startIndex < 0) {
                        break;
                    }
                }
                startIndex++;
                while (nums[endIndex] == nums[mid]) {
                    endIndex++;
                    if (endIndex > nums.length - 1) {
                        break;
                    }
                }
                endIndex--;
                return new int[]{startIndex, endIndex};
            }
            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
