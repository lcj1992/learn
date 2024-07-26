package ds.tree.binary_tree;

import common.TreeNode;
import common.Utils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">...</a>
 * 反转二叉树，也叫镜像二叉树
 *
 * @author foolchild
 * @date 2019/5/11
 */
public class InvertTreeTest {

    @Test
    public void test() {
        TreeNode treeNode = invertTree(TreeNode.create(4, 2, 7, 1, 3, 6, 9));
        Utils.print(treeNode);
        treeNode = invertTreeStack(TreeNode.create(4, 2, 7, 1, 3, 6, 9));
        Utils.print(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTreeStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (right != null) {
                deque.addFirst(right);
            }
            if (left != null) {
                deque.addFirst(left);
            }
        }
        return root;
    }
}
