package algo.dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">...</a>
 *
 * @author lichuangjian
 * @date 2023/8/2
 */
public class LongestPalindromeTest {

    @Test
    public void test(){
        LongestPalindromeTest solution = new LongestPalindromeTest();
        String babad = solution.longestPalindrome("xaabacxcabaaxcabaax");
        System.out.println(babad);
    }

    /**
     * 状态：dp[i][j]第i个字符到第j个字符之间是否存在回文子串
     * 转移方程：
     * 1. 长度为1: dp[i][i] = true
     * 2. 长度为2: dp[i][i+1] = (s.charAt(i) == s.charAr(i+1))
     * 3. 长度为n(n>=2): dp[i][j] = dp[i+1][j-1] && s.charAt(j-len+1) == s.charAt(j)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int maxLen = 0;
        int begin = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        // 单个字符肯定是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            maxLen = 1;
            begin = i;
        }
        // 检查两个字符
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
                begin = i;
            }
        }
        // 检查多个字符
        for (int len = 3; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                int j = i + len - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
