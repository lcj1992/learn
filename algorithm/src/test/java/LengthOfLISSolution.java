import java.util.*;

/**
 * @author lichuangjian
 * @date 2023/6/28
 */
public class LengthOfLISSolution {

    public static void main(String[] args) {
        LengthOfLISSolution solution = new LengthOfLISSolution();
        int[] nums = new int[]{5, 7, -24, 12, 13, 2, 3, 12, 5, 6, 35};
        int i = solution.lengthOfLIS1(nums);
        System.out.println(i);
    }

    // 1、确认是否存在最优子结构
    // 2、确认状态方程是啥
    // 3、确认状态如何保存
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

    public int lengthOfLIS1(int[] nums) {
        int length = nums.length;
        int result = 1;
        for (int i = 0; i < length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(nums[i]);
            for (int j = i + 1; j < length; j++) {
                Integer top = stack.peek();
                // 栈顶元素小于当前值
                if (top < nums[j]) {
                    stack.push(nums[j]);
                    if (stack.size() > result) {
                        result = stack.size();
                    }
                    continue;
                }
                // 栈顶元素大于当前值，比较栈顶元素是否小于当前值
                if (top > nums[j] && stack.size() > 1) {
                    Integer pop = stack.pop();
                    Integer peek = stack.peek();
                    if (peek < nums[j]) {
                        stack.push(nums[j]);
                    } else {
                        stack.push(pop);
                    }
                }
            }
        }
        return result;
    }

}
