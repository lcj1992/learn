package algo.search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array">...</a>
 * 搜索旋转数组
 * 解题思路：
 * 1. 二分法的变种
 *
 * @author lichuangjian
 * @date 2023/8/18
 * today
 */
public class SearchTest {

    @Test
    public void test() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        SearchTest solution = new SearchTest();
        System.out.println(solution.search(nums, 0));
    }

    // 二分搜索变种
    //          /
    //         /
    //        /
    //              /
    //             /
    //            /
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (r + l) / 2;
            // 中间值
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            // 调整left和right指针的逻辑有差异
            if (nums[0] <= midNum) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
