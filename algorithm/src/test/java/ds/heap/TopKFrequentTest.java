package ds.heap;

import common.Utils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/top-k-frequent-elements/">...</a>
 * 前k个高频元素
 */
public class TopKFrequentTest {

    @Test
    public void test() {
        int[] res = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Utils.print(res);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Integer num : freqMap.keySet()) {
            queue.add(new int[]{num, freqMap.get(num)});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
