package algo.backtrack;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/description/">...</a>
 * 子集
 * today
 */
public class SubsetsTest {

    @Test
    public void test() {
        List<List<Integer>> res = subsets(new int[]{1, 2, 3});
        Utils.print(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        backtrack(state, nums, 0, res);
        return res;
    }

    private void backtrack(List<Integer> state, int[] nums, int start, List<List<Integer>> res) {
        for (int i = start; i < nums.length; i++) {
            state.add(nums[i]);
            res.add(new ArrayList<>(state));
            backtrack(state, nums, i + 1, res);
            state.remove(state.size() - 1);
        }
    }
}
