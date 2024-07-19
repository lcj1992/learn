package algo.double_pointers;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/">...</a>
 * <a href="https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/">...</a>
 * 至多包含 K 个不同字符的最长子串
 * 解题思路：
 * 1. map记录字符和字符坐标
 * 2. 和最长无重复子串不同的是，调整left指针的判定条件
 * 3. 最长无重复子串是当出现重复时，本题是当出现的字符数大于k时
 * 4. 使用LinkedHashMap来存储，便于移除第一个key的entry
 */
public class LengthOfLongestSubstringKDistinctTest {
    @Test
    public void test() {
        String s = "eceba";
        int result = lengthOfLongestSubstringKDistinct(s, 2);
        System.out.println(result);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // left 记录最左侧指针
        // right 记录最右侧指针
        // linked map记录字符和最新的坐标
        // 当map的size超过k时，删除第一个key的坐标，并更新left指针
        // 每次都更新res
        int l = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.remove(c);
            map.put(c, r);
            if (map.size() > k) {
                // 调整left指针位置
                Map.Entry<Character, Integer> leftmost = map.entrySet().iterator().next();
                l = leftmost.getValue() + 1;
                map.remove(leftmost.getKey());
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}

