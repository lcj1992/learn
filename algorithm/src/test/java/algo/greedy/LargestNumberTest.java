package algo.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/largest-number/solutions/27403/179-by-ikaruga/">...</a>
 * 描述：最大数，给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
 * 思路：
 * 1. 本质上还是排序，无非是排序的逻辑变了
 */
public class LargestNumberTest {

    @Test
    public void testLargestNumber() {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String result = largestNumber(nums);
        Assert.assertEquals(result, "9534330");
    }


    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}
