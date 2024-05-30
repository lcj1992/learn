package double_pointers;

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
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int left = 0;
        LinkedHashMap<Character, Integer> exists = new LinkedHashMap<>();
        int max = 0;
        for (int current = 0; current < arr.length; current++) {
            Character c = arr[current];
            exists.remove(c);
            exists.put(c, current);
            if (exists.size() > k) {
                // 调整left指针位置
                Map.Entry<Character, Integer> leftmost = exists.entrySet().iterator().next();
                exists.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }
            max = Math.max(max, current - left + 1);
        }
        return max;
    }

}

