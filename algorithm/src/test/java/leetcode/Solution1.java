package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/31
 * Time: 上午9:45
 */
public class Solution1 {

    @Test
    public void test() {
        int[] array = new int[]{7, 2, 4, 1, 5, 6, 3};
        Assert.assertEquals(maxN(array, 3), 14);
        Assert.assertEquals(maxN(array, 4), 16);
    }

    private int maxN(int[] array, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        int currentResult = 0;
        boolean initCurrentResult = false;

        for (int each : array) {
            if (queue.size() < n) {
                queue.add(each);
                result += each;
                continue;
            }
            if (!initCurrentResult) {
                currentResult = result;
                initCurrentResult = true;
            }
            int headVal = queue.poll();
            queue.add(each);
            currentResult = (currentResult - headVal + each);
            result = Math.max(currentResult, result);
        }
        return result;
    }
}