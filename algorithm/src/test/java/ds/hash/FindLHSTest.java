package ds.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-harmonious-subsequence/">...</a>
 */
public class FindLHSTest {

    @Test
    public void test() {
        int res = findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        System.out.println(res);
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;
    }
}
