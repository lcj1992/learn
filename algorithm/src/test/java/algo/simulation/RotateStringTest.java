package algo.simulation;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/rotate-string/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class RotateStringTest {

    @Test
    public void test() {
        System.out.println(rotateString("abc", "bca"));
    }

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}
