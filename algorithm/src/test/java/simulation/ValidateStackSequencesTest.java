package simulation;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/validate-stack-sequences/description/?envType=study-plan-v2&envId=selected-coding-interview">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class ValidateStackSequencesTest {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num); // num 入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
