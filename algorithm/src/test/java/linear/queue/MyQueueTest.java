package linear.queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">...</a>
 * Desc: 基于链表实现的先进先出的线性表
 *
 * @author: foolchild
 * @date: 2019/3/20
 * Time: 上午11:11
 */
public class MyQueueTest {

    @Test
    public void test() {
        MyQueue obj = new MyQueue();
        obj.push(10);
        int param_2 = obj.pop();
        System.out.println(param_2);
        obj.push(11);
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_3);
        System.out.println(param_4);
    }

    /**
     * 栈：先进后出
     * 队列：先进先出
     */
    public static class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
