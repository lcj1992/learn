package leetcode;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/14
 * Time: 下午11:02
 */
public class WildcardChar {

    @Test
    public void test() {
        Assert.assertEquals(isMatch("aa", "a"), false);
        Assert.assertEquals(isMatch("aa", "*"), true);
        Assert.assertEquals(isMatch("cb", "?a"), false);
        Assert.assertEquals(isMatch("adceb", "*a*b"), true);
        Assert.assertEquals(isMatch("acdcb", "a*c?b"), false);
    }


    public boolean isMatch(String s, String p) {
        // dp[i][j]表示s到i位置,p到j位置是否匹配!
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                char pc = p.charAt(j - 1);
                char c = s.charAt(i - 1);
                if (pc == '?' || pc == c) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
