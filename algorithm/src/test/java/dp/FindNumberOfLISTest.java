package dp;

import org.junit.Test;

/**
 * @author foolchid
 * @date 2024/5/20
 **/
public class FindNumberOfLISTest {

    @Test
    public void test() {
        int[] ints = {1, 3, 5, 4, 7};
        int numberOfLIS = findNumberOfLIS(ints);
        System.out.println(numberOfLIS);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        int maxSize = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max == dp[i]) {
                maxSize++;
            }
            if (max < dp[i]) {
                max = dp[i];
                maxSize = 1;
            }
        }
        return maxSize;
    }
}
