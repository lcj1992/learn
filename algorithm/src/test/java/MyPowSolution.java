/**
 * @author lichuangjian
 * @date 2023/6/12
 */
public class MyPowSolution {

    public static void main(String[] args) {
        MyPowSolution solution = new MyPowSolution();
        double v = solution.myPow(1.00000, 2147483647);
        System.out.println(v);
    }


    public double myPow(double x, int n) {
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
}
