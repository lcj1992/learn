package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">...</a>
 * 二叉树的最近公共祖先
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class LowestCommonAncestorTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode node1 = treeNode.left;
        TreeNode node2 = treeNode.right;
        TreeNode result = lowestCommonAncestor(treeNode, node1, node2);
        System.out.println(result.val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }

    /**
     * 仅含p，返回p节点
     * 仅含q，返回q节点
     * 既含p，又含q，返回p、q的最近公共祖先
     */
    public TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 左子树是否包含p或者q
        TreeNode left = search(root.left, p, q);
        // 右子树是否包含p或者q
        TreeNode right = search(root.right, p, q);
        // 左子树不包含p且不包含q且题目中说了一定存在，所以可以直接返回right
        if (left == null) {
            return right;
        }
        // 同理，右子树不包含p且不包含q且题目中说了一定存在，所以可以直接返回left
        if (right == null) {
            return left;
        }
        // 左右子树均包含p或者q，说明一个在左子树，一个在右子树，最近的公共祖先就是当前root
        return root;
    }
}
