package backtrack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/description/">...</a>
 * 全排列
 * 思路：回溯
 * <p>
 * author: foolchild
 * date: 2019/5/18
 */
public class PermuteTest {

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        dfs(res, nums, list);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.addLast(num);
            dfs(res, nums, list);
            list.removeLast();
        }
    }

}
