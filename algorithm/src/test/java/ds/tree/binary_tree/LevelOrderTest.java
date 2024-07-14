package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">...</a>
 * 二叉树的层序遍历
 *
 * @author lichuangjian
 * @date 2023/6/21
 */
public class LevelOrderTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.create(1, 2, 3, 4, null, null, 5);
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        List<List<Integer>> results = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeFirst();
                res.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            results.add(res);
        }
        return results;
    }
}





