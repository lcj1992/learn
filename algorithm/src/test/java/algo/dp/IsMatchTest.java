package algo.dp;

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
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;
        for (int j = 1; j <= pl; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    // 这里的*和grep的*不同
                    char prePc = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2];
                    if (match(sc, prePc)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(sc, pc)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sl][pl];
    }

    private boolean match(char sc, char pc) {
        return pc == '.' || sc == pc;
    }

}
