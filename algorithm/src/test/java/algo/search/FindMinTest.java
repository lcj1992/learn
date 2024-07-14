package algo.search;

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
        int res = findMin(new int[]{4, 4, 4, 4, 4, 4, 5, 6, 7, 0, 1, 4});
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
                System.out.println("hehe");
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
                System.out.println("haha");
            } else {
                r -= 1;
                System.out.println("heihei");
            }
        }
        return nums[l];
    }
}
