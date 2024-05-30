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

    class MedianFinder {
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        public MedianFinder() {
            queMin = new PriorityQueue<>((a, b) -> (b - a));
            queMax = new PriorityQueue<>((a, b) -> (a - b));
        }

        public void addNum(int num) {
            if (queMin.isEmpty() || num <= queMin.peek()) {
                queMin.offer(num);
                if (queMax.size() + 1 < queMin.size()) {
                    queMax.offer(queMin.poll());
                }
            } else {
                queMax.offer(num);
                if (queMax.size() > queMin.size()) {
                    queMin.offer(queMax.poll());
                }
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
