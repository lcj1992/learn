package hash;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/longest-palindrome/
 * @author foolchid
 * @date 2024/5/28
 **/
public class LongestPalindromeTest {

    @Test
    public void test(){
        int res = longestPalindrome("abccccdd");
        System.out.println(res);
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
