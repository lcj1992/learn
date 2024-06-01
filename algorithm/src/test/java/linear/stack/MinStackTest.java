package linear.stack;

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

        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            Integer peek = minStack.peek();
            minStack.push(Math.min(peek, x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
