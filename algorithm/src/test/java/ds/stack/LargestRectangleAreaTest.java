package ds.stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/">...</a>
 * 题解
 * <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/266844/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/">...</a>
 * today
 *
 */
public class LargestRectangleAreaTest {

    @Test
    public void test() {
        int res = largestRectangleArea(new int[]{6, 7, 5, 2, 4, 5, 9, 3});
        System.out.println(res);
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int area = 0;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        for (int i = 1; i < len; ++i) {
            while (heights[deque.getFirst()] > heights[i]) {
                int height = heights[deque.removeFirst()];
                int width = i - deque.getFirst() - 1;
                area = Math.max(area, height * width);
            }
            deque.addFirst(i);
        }
        return area;
    }
}
