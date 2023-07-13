/**
 * @author lichuangjian
 * @date 2023/6/12
 */
public class MyPowSolution {

    public static void main(String[] args) {
        MyPowSolution solution = new MyPowSolution();
        double v = solution.myPow(2.00000, 11);
        System.out.println(v);
    }


    public double myPow1(double x, int n) {
        boolean flag = n < 0;
        double result = 1;
        long absN = Math.abs((long) n);
        for (int i = 0; i < absN; i++) {
            result = result * x;
        }
        if (flag) {
            return 1 / result;
        }
        return result;
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
}
