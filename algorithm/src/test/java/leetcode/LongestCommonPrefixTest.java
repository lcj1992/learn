package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuangjian
 * @date 2023/7/18
 */
public class LongestCommonPrefixTest {

    @Test
    public void test(){
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
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
