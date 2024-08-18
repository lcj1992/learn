package algo.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/">...</a>
 */
public class CoinChangeTest {

    @Test
    public void test() {
        int res = coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
