package ds.tree.binary_tree.traversal;

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
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.addFirst(cur);
                cur = cur.left;
            }
            cur = deque.getFirst();
            if (cur.right == null || cur.right == pre) {
                deque.removeFirst();
                results.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return results;
    }
}
