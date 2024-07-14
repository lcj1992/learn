package ds.stack;

import org.junit.Test;

import java.util.*;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/">...</a>
 *
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
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (deque.isEmpty()) {
                deque.addFirst(c);
                continue;
            }
            Character peek = deque.getFirst();
            if (c.equals(pairs.get(peek))) {
                deque.removeFirst();
            } else {
                deque.addFirst(c);
            }
        }
        return deque.isEmpty();
    }
}
