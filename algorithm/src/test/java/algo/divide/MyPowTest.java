package algo.divide;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/powx-n/">...</a>
 *
 * @author lichuangjian
 * @date 2023/6/12
 */
public class MyPowTest {

    @Test
    public void test() {
        MyPowTest solution = new MyPowTest();
        double v = solution.myPow(2.00000, 11);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        boolean flag = n < 0;
        long absN = Math.abs((long) n);
        double result = mySubPow(x, absN);
        if (flag) {
            return 1 / result;
        }
        return result;
    }


    public double mySubPow(double x, long n) {
        // 递归中止条件
        if (n == 0) {
            return 1.0;
        }
        double temp = mySubPow(x, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
