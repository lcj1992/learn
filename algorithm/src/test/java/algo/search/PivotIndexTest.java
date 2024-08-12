package algo.search;

import org.junit.Test;

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
        int sumRight = 0;
        for (int num : nums) {
            sumRight += num;
        }
        // int sumRight = Arrays.stream(nums).sum();
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            sumRight -= nums[i];
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }
}
