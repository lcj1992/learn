package ds.array;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/consecutive-characters/">...</a>
 */
public class MaxPowerTest {

    @Test
    public void test() {
        int res = maxPower("leetcode");
        System.out.println(res);
    }

    public int maxPower(String s) {
        int res = 0;
        int cnt = 0;
        Character preC = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (preC == null) {
                preC = c;
            }
            if (preC == c) {
                cnt++;
            } else {
                cnt = 1;
            }
            preC = c;
            res = Math.max(res, cnt);
        }
        return res;
    }
}
