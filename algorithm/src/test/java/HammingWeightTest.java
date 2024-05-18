import org.junit.Assert;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/19
 * Time: 上午8:43
 */
public class HammingWeightTest {

    @Test
    public void test() {
        Assert.assertEquals(hammingWeight(1), 1);
        Assert.assertEquals(hammingWeight(2), 1);
        Assert.assertEquals(hammingWeight(3), 2);
        Assert.assertEquals(hammingWeight(4), 1);
        Assert.assertEquals(hammingWeight(5), 2);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1)
                result += 1;
        }
        return result;
    }
}
