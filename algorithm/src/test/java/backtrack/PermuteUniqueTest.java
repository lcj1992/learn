package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/
 * @author foolchid
 * @date 2024/5/23
 **/
public class PermuteUniqueTest {

    @Test
    public void test() {

    }

    List<Integer> nums;
    List<List<Integer>> res;

    void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    void dfs(int x) {
        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums));  // 添加排列方案
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = x; i < nums.size(); i++) {
            if (set.contains(nums.get(i))) continue;            // 重复，因此剪枝
            set.add(nums.get(i));
            swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
            dfs(x + 1);              // 开启固定第 x + 1 位元素
            swap(i, x);              // 恢复交换
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = new ArrayList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
        dfs(0);
        return res;
    }
}
