package dp;

/**
 * @author lichuangjian
 * @date 2023/8/2
 */
public class LongestPalindromeTest {

    public static void main(String[] args) {
        LongestPalindromeTest solution = new LongestPalindromeTest();
        String babad = solution.longestPalindrome("xaabacxcabaaxcabaax");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        // 初始化状态
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        // 状态转移方程
        // dp[i][j]  = dp[i + 1][j -1] && chars[i] == chars[j]
        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int j = L + i - 1;
                if (j >= length) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
