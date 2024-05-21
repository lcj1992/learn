package sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/3982/hua-dong-chuang-kou-by-powcai/">...</a>
 * 无重复字符的最长子串
 *
 * @author lichuangjian
 * @date 2023/6/11
 */
public class LengthOfLongestSubStringSolution {

    public static void main(String[] args) {
        LengthOfLongestSubStringSolution solution = new LengthOfLongestSubStringSolution();
        String s = "abba";
        int i = solution.lengthOfLongestSubstring(s);
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
