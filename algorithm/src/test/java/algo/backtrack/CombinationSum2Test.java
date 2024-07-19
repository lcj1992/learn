package algo.backtrack;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class CombinationSum2Test {

    @Test
    public void test() {
        List<List<Integer>> res = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        Utils.printList(res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 状态（子集）
        List<Integer> state = new ArrayList<>();
        // 对 candidates 进行排序
        Arrays.sort(candidates);
        // 遍历起始点
        int start = 0;
        // 结果列表（子集列表）
        List<List<Integer>> res = new ArrayList<>();
        backtrack(state, target, candidates, start, res);
        return res;
    }

    void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝一：从 start 开始遍历，避免生成重复子集
        // 剪枝二：从 start 开始遍历，避免重复选择同一元素
        // 因为排过序了，所以可以从start开始，比如[1,2]已经选择过了，就没有必要在选[2,1]了
        for (int i = start; i < choices.length; i++) {
            // 剪枝三：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            // 因为排过序了，选择i时结果已经不满足了，比nums[i]大的肯定也不满足了，直接break而不是continue
            if (target - choices[i] < 0) {
                break;
            }
            // 剪枝四：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
            // 比如[1,2a,2b]，需要[1,2a, 2b]，但不需要[1,2b,2a]了
            if (i > start && choices[i] == choices[i - 1]) {
                continue;
            }
            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            // 每个字符只能使用一次，所以下次选择，要从i+1开始
            backtrack(state, target - choices[i], choices, i + 1, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }


}
