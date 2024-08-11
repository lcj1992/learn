package ds.array;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/rotate-array/">...</a>
 * 轮转数组
 */
public class RotateTest {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        Utils.print(nums);
    }

    /**
     * 多次反转 1 2 3 4 5 6 7 , k =3
     * 第一次反转： 4 3 2 1 5 6 7
     * 第二次反转： 7 6 5 1 2 3 4
     * 第三次反转： 5 6 7 1 2 3 4
     **/
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int len = nums.length;
        reverse(nums, 0, len - k - 1);
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
