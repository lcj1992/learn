package linear.stack;

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
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }

    /**
     * <a href="https://leetcode.cn/problems/find-median-from-data-stream/solutions/2361972/295-shu-ju-liu-de-zhong-wei-shu-dui-qing-gmdo/?envType=study-plan-v2&envId=selected-coding-interview">...</a>
     */
    static class MedianFinder {
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        public MedianFinder() {
            queMin = new PriorityQueue<>((a, b) -> (b - a));
            queMax = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (queMin.size() != queMax.size()) {
                queMin.add(num);
                queMax.add(queMin.poll());
            } else {
                queMax.add(num);
                queMin.add(queMax.poll());
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                return queMin.peek();
            }
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}
