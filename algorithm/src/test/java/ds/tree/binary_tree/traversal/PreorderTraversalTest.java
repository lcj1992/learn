package ds.tree.binary_tree.traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">...</a>
 * 前序遍历：根左右
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class PreorderTraversalTest {

    @Test
    public void test() {
        TreeNode root = TreeNode.create(1, null, 2, 3);
        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversalStack(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        // 根节点
        results.add(root.val);
        // 左子树
        results.addAll(preorderTraversal(root.left));
        // 右子树
        results.addAll(preorderTraversal(root.right));
        return results;
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.removeFirst();
            results.add(treeNode.val);
            if (treeNode.right != null) {
                deque.addFirst(treeNode.right);
            }
            if (treeNode.left != null) {
                deque.addFirst(treeNode.left);
            }
        }
        return results;
    }
}
