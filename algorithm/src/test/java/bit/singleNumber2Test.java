package bit;

/**
 * https://leetcode.cn/problems/single-number-ii/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class singleNumber2Test {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}
