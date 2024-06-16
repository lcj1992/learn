package math;

import common.Utils;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class ProductExceptSelfTest {

    @Test
    public void test() {
        int[] res = productExceptSelf2(new int[]{1, 2, 3, 4});
        Utils.printArray(res);
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            res[i] = res[i] * tmp;
        }
        return res;

    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] ans = new int[len];
        ans[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }
        return ans;
    }

}
