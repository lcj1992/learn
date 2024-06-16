package dp;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class NthUglyNumberTest {


    @Test
    public void test() {
        int res = nthUglyNumber(20);
        System.out.println(res);
    }

    /**
     * <a href="https://leetcode.cn/problems/ugly-number-ii/solutions/1/san-zhi-zhen-fang-fa-de-li-jie-fang-shi-by-zzxn/">...</a>
     * 这个题解写的最好
     * 官方题解里提到的三个指针p2，p3，p5，但是没有说明其含义，实际上pi的含义是有资格同i相乘的最小丑数的位置。这里资格指的是：如果一个丑数nums[pi]通过乘以i可以得到下一个丑数，那么这个丑数nums[pi]就永远失去了同i相乘的资格（没有必要再乘了），我们把pi++让nums[pi]指向下一个丑数即可。
     * <p>
     * 不懂的话举例说明：
     * <p>
     * 一开始，丑数只有{1}，1可以同2，3，5相乘，取最小的1×2=2添加到丑数序列中。
     * <p>
     * 现在丑数中有{1，2}，在上一步中，1已经同2相乘过了，所以今后没必要再比较1×2了，我们说1失去了同2相乘的资格。
     * <p>
     * 现在1有与3，5相乘的资格，2有与2，3，5相乘的资格，但是2×3和2×5是没必要比较的，因为有比它更小的1可以同3，5相乘，所以我们只需要比较1×3，1×5，2×2。
     * <p>
     * 依此类推，每次我们都分别比较有资格同2，3，5相乘的最小丑数，选择最小的那个作为下一个丑数，假设选择到的这个丑数是同i（i=2，3，5）相乘得到的，所以它失去了同i相乘的资格，把对应的pi++，让pi指向下一个丑数即可。
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
