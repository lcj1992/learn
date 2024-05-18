package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lichuangjian
 * @date 2023/7/8
 */
public class IsValidSolution {

    public static void main(String[] args) {
        IsValidSolution solution = new IsValidSolution();
        String s = "()[]{}";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return true;
        }
        if (chars.length % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        for (int i = 1; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            Character peek = stack.peek();
            if (pairs.get(peek) == chars[i]) {
                stack.pop();
                continue;
            }
            stack.push(chars[i]);
        }
        return stack.isEmpty();
    }
}
