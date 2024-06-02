package tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">...</a>
 * 二叉树的最近公共祖先
 * @author foolchid
 * @date 2024/5/29
 **/
public class LowestCommonAncestorTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});

        System.out.println(treeNode);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
