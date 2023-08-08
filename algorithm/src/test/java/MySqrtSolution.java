/**
 * @author lichuangjian
 * @date 2023/8/9
 */
public class MySqrtSolution {

    public static void main(String[] args) {
        MySqrtSolution solution = new MySqrtSolution();
        int i = solution.mySqrt2(2147483647);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        for (int i = 0; i < x; i++) {
            if (i * i == x) {
                return i;
            }
            long sqrt1 = (long) i * (long) i;
            long sqrt2 = (long) (i + 1) * (long) (i + 1);
            if (sqrt1 < x && sqrt2 > x) {
                return i;
            }
        }
        return -1;
    }

    public int mySqrt2(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
