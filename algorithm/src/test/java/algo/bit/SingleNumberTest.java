package algo.bit;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/single-number/solutions/242211/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/">...</a>
 * 只出现一次的数字
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class SingleNumberTest {

    @Test
    public void test() {
        int[] input = {2, 2, 1};
        int res = singleNumber(input);
        System.out.println(res);
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
