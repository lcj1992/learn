package algo.search;

/**
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array">...</a>
 * 搜索旋转数组
 * 解题思路：
 * 1. 二分法的变种
 *
 * @author lichuangjian
 * @date 2023/8/18
 */
public class SearchTest {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        SearchTest solution = new SearchTest();
        System.out.println(solution.search(nums, 0));
    }

    // 二分搜索变种
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            // 中间值
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            // 调整left和right指针的逻辑有差异
            if (nums[0] <= midNum) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
