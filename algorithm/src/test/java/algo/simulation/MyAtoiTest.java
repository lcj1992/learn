package algo.simulation;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/add-strings/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class MyAtoiTest {

    @Test
    public void test() {
        int res = myAtoi("123");
        System.out.println(res);
    }

    public int myAtoi(String s) {
        char[] c = s.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0;
        int bndry = Integer.MAX_VALUE / 10;
        int i = 1;
        int sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}
