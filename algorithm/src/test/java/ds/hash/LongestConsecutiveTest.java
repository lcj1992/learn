package ds.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/">最长连续序列</a>
 */
public class LongestConsecutiveTest {

    @Test
    public void test() {
        int res = longestConsecutive(new int[]{100, 4, 200, 1, 2, 3});
        System.out.println(res);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            // 找到最小的元素
            if (!set.contains(num - 1)) {
                int curRes = 1;
                while (set.contains(num + 1)) {
                    num++;
                    curRes++;
                }
                res = Math.max(res, curRes);
            }
        }
        return res;
    }
}
