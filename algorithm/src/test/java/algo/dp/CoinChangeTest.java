package algo.dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/coin-change/">...</a>
 * today1
 */
public class CoinChangeTest {

    @Test
    public void test() {
        int res = coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        // 状态：dp[i] 表示金额为i时所需的最少硬币
        // 转移方程：dp[i] = min(dp[i - coin[x]] + 1);
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int coin : coins) {
            dp[coin] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    if (dp[i - coin] == -1) {
                        continue;
                    }
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}
