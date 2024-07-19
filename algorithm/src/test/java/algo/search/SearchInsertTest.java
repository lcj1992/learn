package algo.search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">...</a>
 * 搜索插入位置
 */
public class SearchInsertTest {

    @Test
    public void test() {
        int res = searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(res);
        res = searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
