package math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/majority-element/">...</a>
 * @author lichuangjian
 * @date 2023/8/24
 */
public class MajorityElementTest {

    @Test
    public void test() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int res = majorityElement(nums);
        System.out.println(res);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int half = nums.length / 2;
        for (int num : nums) {
            cntMap.merge(num, 1, Integer::sum);
            if (cntMap.get(num) > half) {
                return num;
            }
        }
        return -1;
    }


    /**
     * 摩尔投票
     * 众数和其他数一一抵消，最终还是会有剩余
     * 如果做不到一一抵消，非众数之间内耗，只会进一步使得众数更占优势。
     * 比如众数如果是2，且都在数组尾部，前面其他数字内耗完了，最后使得votes大于0的只可能是2。
     */
    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums){
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for (int num : nums)
            if (num == x) {
                count++;
            }
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }
}
