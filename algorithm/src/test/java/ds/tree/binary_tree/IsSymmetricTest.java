package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/">...</a>
 * 对称二叉树
 *
 * @author lichuangjian
 * @date 2023/8/2
 */
public class IsSymmetricTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode l, TreeNode r) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(l);
        deque.addFirst(r);
        while (!deque.isEmpty()) {
            l = deque.removeFirst();
            r = deque.removeFirst();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null) {
                return false;
            }
            if (l.val != r.val) {
                return false;
            }
            deque.addFirst(l.left);
            deque.addFirst(r.right);

            deque.addFirst(l.right);
            deque.addFirst(r.left);
        }
        return true;
    }
}
