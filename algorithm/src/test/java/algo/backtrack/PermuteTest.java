package algo.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">...</a>
 * 全排列
 * 思路：回溯
 * 写 backtrack 函数时，需要维护走过的「路径」和当前可以做的「选择列表」，当触发「结束条件」时，将「路径」记入结果集。
 *
 * @author foolchild
 * @date 2019/5/18
 */
public class PermuteTest {

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        backtrack(list, nums, res);
        return res;
    }

    public void backtrack(Deque<Integer> list, int[] nums, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.addLast(num);
            backtrack(list, nums, res);
            list.removeLast();
        }
    }

}
