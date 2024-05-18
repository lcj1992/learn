package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuangjian
 * @date 2023/6/11
 */
public class LengthOfLongestSubStringSolution {

    public static void main(String[] args) {
        LengthOfLongestSubStringSolution solution = new LengthOfLongestSubStringSolution();
        String s = "abcabcbb";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 0) {
            return 0;
        }
        int maxLength = 0;
        char[] chars = s.toCharArray();
        List<Character> results = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            if (results.contains(aChar)) {
                maxLength = Math.max(maxLength, results.size());
                // 找到该字符坐标
                int index = results.indexOf(aChar);
                results = results.subList(index + 1, results.size());
            }
            results.add(aChar);
        }
        maxLength = Math.max(maxLength, results.size());
        return maxLength;
    }
}
