package ds.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-palindrome/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class LongestPalindromeTest {

    @Test
    public void test() {
        int res = longestPalindrome("abccccdd");
        System.out.println(res);
    }


    public int longestPalindrome(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (Character c : freqMap.keySet()) {
            Integer num = freqMap.get(c);
            res += num / 2 * 2;
            if (num % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }


}
