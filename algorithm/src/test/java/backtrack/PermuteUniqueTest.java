package backtrack;

import common.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        backtrack(0, numList, res);
        return res;
    }

    void swap(List<Integer> nums, int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    void backtrack(int x, List<Integer> nums, List<List<Integer>> res) {
        if (x == nums.size() - 1) {
            // 添加排列方案
            res.add(new ArrayList<>(nums));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = x; i < nums.size(); i++) {
            // 重复，因此剪枝
            if (set.contains(nums.get(i))) {
                continue;
            }
            set.add(nums.get(i));
            // 交换，将 nums[i] 固定在第 x 位
            swap(nums, i, x);
            // 开启固定第 x + 1 位元素
            backtrack(x + 1, nums, res);
            // 恢复交换
            swap(nums, i, x);
        }
    }

}
