package leetcode;

import org.junit.Test;

/**
 * @author lichuangjian
 * @date 2023/8/24
 */
public class TitleToNumberTest {

    @Test
    public void test() {
        System.out.println(titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            int num = c - 'A' + 1;
            res += num * (int) Math.pow(26, length - i - 1);
        }
        return res;
    }
}
