package linear.stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/">...</a>
 * @author lichuangjian
 * @date 2023/7/8
 */
public class IsValidTest {

    @Test
    public void test() {
        String s = "([)]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            Character peek = stack.peek();
            if (c.equals(pairs.get(peek))) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
