package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuangjian
 * @date 2023/8/24
 */
public class MajorityElementSolution {

    public static void main(String[] args) {
        MajorityElementSolution solution = new MajorityElementSolution();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int res = solution.majorityElement(nums);
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
}
