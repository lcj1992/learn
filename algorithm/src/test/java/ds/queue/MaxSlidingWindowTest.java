package ds.queue;

import common.Utils;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/">...</a>
 * 滑动窗口最大值
 *
 * @author lichuangjian
 * @date 2023/7/5
 * today
 */
public class MaxSlidingWindowTest {

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] results = maxSlidingWindow(nums, 3);
        Utils.print(results);
        results = maxSlidingWindow2(nums, 3);
        Utils.print(results);
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        TreeMap<Integer, Integer> window = new TreeMap<>((o1, o2) -> -1 * o1.compareTo(o2));
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            window.put(nums[i], i);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = window.firstKey();
        // 滑动窗口
        for (int i = k; i < nums.length; i++) {
            window.put(nums[i], i);
            while (window.firstEntry().getValue() <= i - k) {
                window.pollFirstEntry();
            }
            result[i - k + 1] = window.firstKey();
        }
        return result;
    }


    /**
     * <a href="https://leetcode.cn/problems/sliding-window-maximum/solutions/2361228/239-hua-dong-chuang-kou-zui-da-zhi-dan-d-u6h0/?envType=study-plan-v2&envId=selected-coding-interview">...</a>
     * 单调队列
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            // 保证deque非递减
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.getFirst();
        // 形成窗口后
        for (int i = k; i < nums.length; i++) {
            // 如果窗口最大值等于窗口第一个元素，则要在deque中移除，保证窗口大小
            if (deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            // 保证deque非递减
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.getFirst();
        }
        return res;
    }
}
