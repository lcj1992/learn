package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuangjian
 * @date 2023/6/11
 */
public class ReverseTest {

    @Test
    public void test(){
        ReverseTest solution = new ReverseTest();
        int reverse = solution.reverse(-1);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        int flag = 1;
        long lo = x;
        if (lo < 0) {
            lo = lo * -1;
            flag = -1;
        }
        List<Long> nums = new ArrayList<>();
        if (lo < 10) {
            return (int) lo * flag;
        }
        if (lo == 10) {
            return flag;
        }
        long temp = lo;
        while (temp >= 10) {
            long num = temp % 10;
            nums.add(num);
            temp = temp / 10;
        }
        nums.add(temp);
        long result = 0;
        int i = nums.size();
        for (Long num : nums) {
            if (num == 0) {
                i--;
                continue;
            }
            result += num * Math.pow(10, i - 1);
            i--;
        }
        result = result * flag;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE - 1) {
            return 0;
        }
        return (int) result;
    }
}
