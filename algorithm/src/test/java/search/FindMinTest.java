package search;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/">...</a>
 * 寻找旋转排序数组中的最小值 II
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class FindMinTest {

    @Test
    public void test() {
        int res = findMin2(new int[]{4, 5, 6, 7, 0, 1, 4});
        System.out.println(res);
    }

    public int findMin2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
                continue;
            }
            if (nums[mid] < nums[r]) {
                r = mid - 1;
            }
            if (nums[mid] == nums[r]) {
                r = mid - 1;
                res = mid;
            }
        }
        return nums[res];
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];

    }
}
