package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">...</a>
 */
public class DiameterOfBinaryTreeTest {

    @Test
    public void test() {
        int res = diameterOfBinaryTree(TreeNode.create(1, 2, 3, 4, 5));
        System.out.println(res);
    }

    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 1;
        depth(root);
        //-1是长度=节点数-1
        return res - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        // +1是计算节点数（左子树的节点数+右子树的节点数+根节点本身），
        res = Math.max(res, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
