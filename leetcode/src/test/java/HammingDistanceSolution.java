import org.junit.Assert;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/19
 * Time: 上午9:15
 */
public class HammingDistanceSolution {

    @Test
    public void test() {
        Assert.assertEquals(hammingDistance(1, 4), 2);
        Assert.assertEquals(hammingDistance(1, 5), 1);
        Assert.assertEquals(hammingDistance(93, 73), 2);
    }

    public int hammingDistance(int x, int y) {
        int diff = 0;
        for (int i = 0; i < 32; i++) {
            int xBit = x >> i;
            int yBit = y >> i;
            if (((xBit ^ yBit) & 1) == 1) {
                diff++;
            }
        }
        return diff;
    }
}
