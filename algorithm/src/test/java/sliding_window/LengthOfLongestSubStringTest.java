package sliding_window;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/3982/hua-dong-chuang-kou-by-powcai/">...</a>
 * 无重复字符的最长子串
 * 思路：
 * 1. map记录出现过的字符，调整left指针，最大长度即为当前值和（当前指针-left指针+1）两者的最大值；
 * 2. 要注意当character出现重复时，可能left指针已经领先于character的上一个坐标了。Math.max(left, exists.get(character) + 1);
 *
 * @author lichuangjian
 * @date 2023/6/11
 */
public class LengthOfLongestSubStringTest {

    @Test
    public void test() {
        String s = "abba";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        int max = 0;
        char[] chars = s.toCharArray();
        // 记录最新字符的坐标
        Map<Character, Integer> exists = new HashMap<>();
        int left = 0;
        for (int current = 0; current < length; current++) {
            char character = chars[current];
            if (exists.containsKey(character)) {
                left = Math.max(left, exists.get(character) + 1);
            }
            exists.put(character, current);
            max = Math.max(max, current - left + 1);
        }
        return max;
    }

}
