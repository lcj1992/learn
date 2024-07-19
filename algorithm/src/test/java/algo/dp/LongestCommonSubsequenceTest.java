package algo.dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/qJnOS7/">...</a>
 * 描述：LCR 095. 最长公共子序列
 * 解题思路：
 *
 * @author foolchid
 * @date 2024/5/20
 **/
public class LongestCommonSubsequenceTest {

    @Test
    public void test() {
        int result = longestCommonSubsequence("abcde", "ace");
        System.out.println(result);
    }

    //      a   b   c   d   e
    //  a   1   1   1   1   1
    //  c   1   1   2   2   2
    //  e   1   1   2   2   3
    // 状态：截至text1第i个字符和text2第j个字符的最长公共子序列
    // 转移方程：
    // 1. t1[i] == t2[j], dp[i][j] = dp[i - 1][j - 1] + 1;
    // 2. t1[i] != t2[j], dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[l1][l2];
    }
}
