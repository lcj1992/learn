package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class FlattenTest {

    @Test
    public void test() {
        TreeNode tree = TreeNode.create(1, 2, 5, 3, 4, null, 6);
        flatten(tree);
        while (tree != null) {
            System.out.println(tree.val);
            tree = tree.right;
        }

    }

    /**
     * 先序遍历变种
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        TreeNode pre = null;
        while (!deque.isEmpty()) {
            TreeNode cur = deque.removeFirst();
            if (pre != null) {
                pre.right = cur;
                pre.left = null;
            }
            if (cur.right != null) {
                deque.addFirst(cur.right);
            }
            if (cur.left != null) {
                deque.addFirst(cur.left);
            }
            pre = cur;
        }
    }
}
