package ds.stack;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-median-from-data-stream/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class MedianFinderTest {

    @Test
    public void test() {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        double res = finder.findMedian();
        System.out.println(res);
        finder.addNum(3);
        res = finder.findMedian();
        System.out.println(res);
        for (int i = 0; i < 6; i++) {
            finder.addNum(i + 3);
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/find-median-from-data-stream/solutions/2361972/295-shu-ju-liu-de-zhong-wei-shu-dui-qing-gmdo/?envType=study-plan-v2&envId=selected-coding-interview">...</a>
     */
    static class MedianFinder {
        // 比中位数小的堆，堆顶是比中位数小的最大值
        PriorityQueue<Integer> queMin;
        // 比中位数大的堆，堆顶是比中位数大的最小值
        PriorityQueue<Integer> queMax;

        public MedianFinder() {
            queMin = new PriorityQueue<>((a, b) -> (b - a));
            queMax = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (queMin.size() > queMax.size()) {
                // 再向大的加
                queMin.offer(num);
                queMax.offer(queMin.poll());
            } else {
                // 先向小的加
                queMax.offer(num);
                queMin.offer(queMax.poll());
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                // 如果是奇数，则返回小的堆顶元素
                return queMin.peek();
            }
            // 如果是偶数，则取两个堆顶的平均值
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}
