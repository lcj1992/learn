

import java.util.*;

/**
 * @author lichuangjian
 * @date 2023/7/5
 */
public class MaxSlidingWindowSolution {

    public static void main(String[] args) {
        MaxSlidingWindowSolution maxSlidingWindowSolution = new MaxSlidingWindowSolution();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] results = maxSlidingWindowSolution.maxSlidingWindow1(nums, 3);
        for (int result : results) {
            System.out.println(result);
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        PriorityQueue<int[]> window = new PriorityQueue<>((o1, o2) -> -1 * Integer.compare(o1[0], o2[0]));
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            window.offer(new int[]{nums[i], i});
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = window.peek()[0];
        // 滑动窗口
        for (int i = k; i < nums.length; i++) {
            window.offer(new int[]{nums[i], i});
            while (window.peek()[1] <= i - k) {
                window.poll();
            }
            result[i - k + 1] = window.peek()[0];
        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
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
}
