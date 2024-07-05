package algo.backtrack;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     *
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(state, nums, 0, visited, ans);
        return ans;
    }

    public void backtrack(List<Integer> state, int[] nums, int idx, boolean[] visited, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            state.add(nums[i]);
            visited[i] = true;
            backtrack(state, nums, idx + 1, visited, res);
            visited[i] = false;
            state.remove(idx);
        }
    }

}
