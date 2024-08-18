package algo.dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/">...</a>
 */
public class MinDistanceTest {

    @Test
    public void test() {
        int res = minDistance("horse", "ros");
        System.out.println(res);
    }

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        // 有一个字符串为空串
        if (l1 * l2 == 0) {
            return l1 + l2;
        }

        // DP 数组
        int[][] dp = new int[l1 + 1][l2 + 1];

        // 边界状态初始化
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[l1][l2];
    }
}
