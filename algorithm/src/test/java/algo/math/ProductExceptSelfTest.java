package algo.math;

import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 * today
 **/
public class ProductExceptSelfTest {

    @Test
    public void test() {
        int[] res = productExceptSelf(new int[]{1, 2, 3, 4});
        Utils.print(res);
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        // 从前向后记录乘积
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // 从后向前记录乘积
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            res[i] = res[i] * tmp;
        }
        return res;
    }
}
