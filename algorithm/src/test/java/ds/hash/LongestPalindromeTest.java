package ds.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-palindrome/">...</a>
 * @author foolchid
 * @date 2024/5/28
 **/
public class LongestPalindromeTest {

    @Test
    public void test(){
        int res = longestPalindrome2("abccccdd");
        System.out.println(res);
    }


    public int longestPalindrome2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, (a, b) -> a + b);
        }
        int res = 0;
        for (Character character : map.keySet()) {
            Integer num = map.get(character);
            res += num / 2 * 2;
            if (num % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


}
