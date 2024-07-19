package algo.dp;

import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/23
 * Time: 下午2:02
 */
public class LongestCommonSubStringTest {

    @Test
    public void test() {
        String str1 = "ider.cs@gmail.com";
        String str2 = "blog.iderzheng.com";
        System.out.println(longestCommonSubString(str1, str2));
    }

    // 状态：dp[i][j] 包含str1[i-1],str2[j-1]的最长公共子串
    // 转移方程：
    // 1. str1[i-1] == str2[j-1], dp[i][j] = dp[i-1][j-1] + 1
    // 2. str1[i-1] != str2[j-1], dp[i][j] = 0
    private String longestCommonSubString(String str1, String str2) {
        int maxLen = 0;
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        int end = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        end = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(end - maxLen, end);
    }
}
