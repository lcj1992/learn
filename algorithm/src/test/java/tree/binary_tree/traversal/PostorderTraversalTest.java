package tree.binary_tree.traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">...</a>
 * 后序遍历：左右根
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class PostorderTraversalTest {

    @Test
    public void test() {
        TreeNode root = TreeNode.create(1, null, 2, 3);
        System.out.println(postorderTraversalStack(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        // 左子树
        results.addAll(postorderTraversal(root.left));
        // 右子树
        results.addAll(postorderTraversal(root.right));
        // 根节点
        results.add(root.val);
        return results;
    }

    public List<Integer> postorderTraversalStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.addFirst(current);
                current = current.left;
            }
            current = deque.getFirst();
            if (current.right == null || current.right == lastVisited) {
                deque.removeFirst();
                results.add(current.val);
                lastVisited = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        return results;
    }
}
