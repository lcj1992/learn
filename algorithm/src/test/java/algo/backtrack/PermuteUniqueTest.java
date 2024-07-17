package algo.backtrack;

import common.Utils;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/">...</a>
 *
 * @author foolchid
 * @date 2024/5/23
 **/
public class PermuteUniqueTest {

    @Test
    public void test() {
        List<List<Integer>> res = permuteUnique(new int[]{1, 2, 2});
        Utils.printList(res);
    }

    /**
     * <a href="https://www.bilibili.com/video/BV1R84y1i7Tm/">...</a>
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> state = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(state, nums, visited, ans);
        return ans;
    }

    public void backtrack(Deque<Integer> state, int[] nums, boolean[] visited, List<List<Integer>> res) {
        if (state.size() == nums.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 因为有序，[1a,1b]选过之后，[1b,1a]可以直接跳过
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            state.addLast(nums[i]);
            visited[i] = true;
            backtrack(state, nums, visited, res);
            visited[i] = false;
            state.removeLast();
        }
    }

}
