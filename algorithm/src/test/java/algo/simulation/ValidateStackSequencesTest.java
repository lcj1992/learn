package algo.simulation;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/validate-stack-sequences/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class ValidateStackSequencesTest {

    @Test
    public void test() {
        boolean res = validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        System.out.println(res);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for (int k : pushed) {
            deque.addFirst(k);
            while (!deque.isEmpty() && deque.getFirst() == popped[j]) {
                deque.removeFirst();
                j++;
            }
        }
        return deque.isEmpty();
    }

}
