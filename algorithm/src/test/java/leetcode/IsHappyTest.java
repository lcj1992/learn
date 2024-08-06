package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuangjian
 * @date 2023/8/25
 */
public class IsHappyTest {

    @Test
    public void test(){
        boolean happy = isHappy(2);
        System.out.println(happy);
    }

    public boolean isHappy(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int res = 0;
        Set<Integer> existed = new HashSet<>();
        while (true) {
            for (char aChar : chars) {
                res += (int) Math.pow(aChar - '1' + 1, 2);
            }
            if (res == 1) {
                return true;
            }
            if (existed.contains(res)) {
                return false;
            }
            existed.add(res);
            chars = Integer.toString(res).toCharArray();
            res = 0;
        }
    }
}
