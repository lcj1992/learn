package algo.backtrack;

import common.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class PathSumTest {


    @Test
    public void test() {
        List<List<Integer>> res = pathSum(TreeNode.create(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22);
        res.forEach(System.out::println);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(path, root, targetSum, res);
        return res;
    }

    void backtrack(LinkedList<Integer> path, TreeNode root, int tar, LinkedList<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        backtrack(path, root.left, tar, res);
        backtrack(path, root.right, tar, res);
        path.removeLast();
    }


}
