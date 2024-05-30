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
        int res = findMin(new int[]{2, 2, 2, 0, 1});
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];

    }
}
