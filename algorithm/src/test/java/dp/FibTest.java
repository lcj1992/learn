package dp;

/**
 * https://leetcode.cn/problems/fibonacci-number/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class FibTest {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
