package leetcode;

import org.junit.Test;

/**
 * @author lichuangjian
 * @date 2023/7/14
 */
public class SearchInsertTest {

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 6, 7, 9};
        int index = searchInsert(nums, 1);
        System.out.println(index);
    }

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        int result = length;
        while (start <= end) {
            int middle = (end + start) / 2;
            if (nums[middle] >= target) {
                end = middle - 1;
                result = middle;
            } else {
                start = middle + 1;
            }
        }
        return result;
    }
}
