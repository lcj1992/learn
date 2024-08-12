package ds.stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/">...</a>
 *
 * @author foolchid
 * @date 2024/5/30
 * today
 **/
public class MaxChunksToSortedTest {

    @Test
    public void test() {
        int res = maxChunksToSorted(new int[]{1, 1, 2, 1, 1, 3, 4, 5, 1, 6});
        System.out.println(res);
    }

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (Integer num : arr) {
            // 栈不为空，且栈顶元素大于num
            if (!deque.isEmpty() && deque.getFirst() > num) {
                Integer head = deque.removeFirst();
                while (!deque.isEmpty() && deque.getFirst() > num) {
                    deque.removeFirst();
                }
                deque.addFirst(head);
                continue;
            }
            deque.addFirst(num);
        }
        return deque.size();
    }

}
