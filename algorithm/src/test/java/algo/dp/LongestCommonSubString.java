package algo.dp;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/23
 * Time: 下午2:02
 */
public class LongestCommonSubString {

    public static void main(String[] args) {
        String str1 = "ider.cs@gmail.com";
        String str2 = "blog.iderzheng.com";
        System.out.println(longestCommonSubString(str1, str2));
    }

    private static String longestCommonSubString(String str1, String str2) {
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
