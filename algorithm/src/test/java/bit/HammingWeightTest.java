package bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/number-of-1-bits/">...</a>
 *
 * @author foolchild
 * @date 2024/05/30
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
