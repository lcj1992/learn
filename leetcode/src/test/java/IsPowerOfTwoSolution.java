import org.junit.Assert;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/19
 * Time: 上午8:40
 */
public class IsPowerOfTwoSolution {

    @Test
    public void test() {
        Assert.assertEquals(isPowerOfTwo(64), true);
        Assert.assertEquals(isPowerOfTwo(128), true);
        Assert.assertEquals(isPowerOfTwo(127), false);
    }


    private boolean isPowerOfTwo(int n) {
        return n == 2 || n == 1 || n % 2 == 0 && n != 0 && isPowerOfTwo(n / 2);
    }
}
