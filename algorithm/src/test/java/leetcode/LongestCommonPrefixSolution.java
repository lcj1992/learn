package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuangjian
 * @date 2023/7/18
 */
public class LongestCommonPrefixSolution {

    public static void main(String[] args) {
        LongestCommonPrefixSolution solution = new LongestCommonPrefixSolution();
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        List<char[]> input = new ArrayList<>();
        for (String str : strs) {
            int length = str.length();
            input.add(str.toCharArray());
            minLength = Math.min(length, minLength);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char c = input.get(0)[i];
            for (char[] chars : input) {
                if (c != chars[i]) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }
}
