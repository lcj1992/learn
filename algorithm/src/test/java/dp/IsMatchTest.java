package dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/regular-expression-matching/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class IsMatchTest {

    @Test
    public void test() {
        boolean res = isMatch("bd", "b*d*");
        System.out.println(res);
    }


    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    // p[j-1]字符匹配0次，注意这里的*和grep的*不一样
                    dp[i][j] = dp[i][j - 2];
                    // p[j-1]字符匹配一次或多次
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // 当前字符匹配上
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
