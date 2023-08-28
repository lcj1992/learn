import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuangjian
 * @date 2023/8/26
 */
public class StackSolution {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();// 返回 2
        System.out.println(top);

        int pop = myStack.pop();// 返回 2
        System.out.println(top);

        boolean empty = myStack.empty();// 返回 False
        System.out.println(empty);

    }

    public static class MyStack {

        private Deque<Integer> elements;

        public MyStack() {
            this.elements = new ArrayDeque<>();
        }

        public void push(int x) {
            elements.addLast(x);
        }

        public int pop() {
            return elements.removeLast();
        }

        public int top() {
            return elements.peekLast();
        }

        public boolean empty() {
            return elements.isEmpty();
        }
    }
}
