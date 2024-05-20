package dp;

import org.junit.Test;

/**
 * @author foolchid
 * @date 2024/5/20
 **/
public class LongestCommonSubsequenceTest {

    @Test
    public void test() {
        int result = longestCommonSubsequence("abcde", "ace");
        System.out.println(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();
        int[][] dp = new int[text1Length + 1][text2Length + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2Length; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }
}
