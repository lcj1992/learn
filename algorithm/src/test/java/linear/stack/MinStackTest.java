package linear.stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author foolchid
 * @date 2024/5/28
 **/
public class MinStackTest {

    @Test
    public void test() {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.pop();
        obj.push(11);
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }

    class MinStack {

        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
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
