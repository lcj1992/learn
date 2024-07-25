package algo.backtrack;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class CombinationSumTest {

    @Test
    public void test() {
        List<List<Integer>> res = combinationSum(new int[]{2, 3, 6, 7}, 7);
        Utils.print(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 状态（子集）
        List<Integer> state = new ArrayList<>();
        // 对 candidates 进行排序
        Arrays.sort(candidates);
        // 遍历起始点
        int start = 0;
        // 结果列表（子集列表）
        List<List<Integer>> res = new ArrayList<>();
        backtrack(state, candidates, start, target, res);
        return res;
    }

    void backtrack(List<Integer> state, int[] choices, int start, int target, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        // 因为有序[2,2,3]选过之后，就没必要[3,2,2]了
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            // 因为有序，当前节点i不可选，那么比i大的节点更不可能满足条件，直接break，而不是continue
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            // 因为可以重复选，所以这里下次选择的坐标仍为i
            backtrack(state, choices, i, target - choices[i], res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }


}
