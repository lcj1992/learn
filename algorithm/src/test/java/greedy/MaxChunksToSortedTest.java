package greedy;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 *
 * @author foolchid
 * @date 2024/5/30
 **/
public class MaxChunksToSortedTest {

    public int maxChunksToSorted(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : arr) {
            if (!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                while (!stack.isEmpty() && num < stack.getLast()) {
                    stack.removeLast();
                }
                stack.addLast(head);
            } else stack.addLast(num);
        }
        return stack.size();
    }

}
