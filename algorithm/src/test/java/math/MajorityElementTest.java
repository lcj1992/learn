package math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/majority-element/
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
            if (cntMap.containsKey(num)) {
                cntMap.put(num, cntMap.get(num) + 1);
            } else {
                cntMap.put(num, 1);
            }
            if (cntMap.get(num) > half) {
                return num;
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for (int num : nums)
            if (num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }
}
