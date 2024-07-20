package ds.stack;

import common.Utils;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures/">...</a>
 * 每日温度
 */
public class DailyTemperaturesTest {

    @Test
    public void test() {
        int[] res = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        Utils.printArray(res);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.getFirst()]) {
                int prevIndex = stack.removeFirst();
                ans[prevIndex] = i - prevIndex;
            }
            stack.addFirst(i);
        }
        return ans;
    }
}
