package linear;

import linear.stack.Stack;
import org.junit.Test;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 上午10:21
 */
public class StackTest {

    @Test
    public void test() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack);

        Integer pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);

        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
    }
}
