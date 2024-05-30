package search;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index/">...</a>
 * 寻找数组的中心下标
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class PivotIndexTest {

    @Test
    public void test() {
        int res = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(res);
    }

    public int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int sumRight = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            sumRight -= nums[i];
            // 若左侧元素和等于右侧元素和，返回中心下标 i
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }
}
