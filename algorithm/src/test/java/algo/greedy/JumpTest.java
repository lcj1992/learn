package algo.greedy;


import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii">...</a>
 */
public class JumpTest {

    @Test
    public void test() {
        int res = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(res);
    }

    public int jump(int[] nums) {
        // 跳到i时，可以再跳的最远距离
        int rightMax = 0;
        // 跳steps步时，可以跳的最远距离
        int end = 0;
        // 跳的步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            rightMax = Math.max(rightMax, i + nums[i]);
            if (i == end) {
                end = rightMax;
                steps++;
            }
        }
        return steps;
    }
}
