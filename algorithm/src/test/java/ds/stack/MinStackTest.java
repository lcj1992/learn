package ds.stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/min-stack">...</a>/
 * 最小栈
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class MinStackTest {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // 返回 -3.
        minStack.pop();
        minStack.top(); // 返回 0.
        minStack.getMin(); // 返回 -2.
    }

    /**
     * 思路一：
     * 借助一个minStack来存储stack中最小值
     */
    public static class MinStack {

        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.addFirst(x);
            } else {
                Integer peek = minStack.getFirst();
                minStack.push(Math.min(peek, x));
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.getFirst();
        }

        public int getMin() {
            return minStack.getFirst();
        }
    }
}
