package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">...</a>
 * 二叉树右视图
 * today
 */
public class RightSideViewTest {

    @Test
    public void test() {
        TreeNode tree = TreeNode.create(1, 2, 3, null, 5, null, 4);
        List<Integer> res = rightSideView(tree);
        System.out.println(res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        List<Integer> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode node = deque.getFirst();
            res.add(node.val);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                node = deque.removeFirst();
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
            }
        }
        return res;
    }
}
