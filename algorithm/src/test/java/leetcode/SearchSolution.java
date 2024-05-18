package leetcode;

/**
 * @author lichuangjian
 * @date 2023/8/18
 */
public class SearchSolution {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        SearchSolution solution = new SearchSolution();
        System.out.println(solution.search(nums, 0));
    }

    // 二分搜索变种
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            // 中间值
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            //
            if (nums[0] <= midNum) {
                if (nums[0] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
