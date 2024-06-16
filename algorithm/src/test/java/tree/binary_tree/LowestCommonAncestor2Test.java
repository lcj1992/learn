package tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class LowestCommonAncestor2Test {

    @Test
    public void test() {
        TreeNode root = TreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode node1 = root.left;
        TreeNode node2 = root.right;
        TreeNode res = lowestCommonAncestor(root, node1, node2);
        System.out.println(res.val);
    }

    /**
     * 这个是二叉搜索树，左子树都比节点值小，右子树逗比节点值大
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp = root;
        while (true) {
            //  p和q都比root值小，则最近公共祖先肯定在左子树上，tmp = tmp.left
            if (p.val < tmp.val && q.val < tmp.val) {
                tmp = tmp.left;
                continue;
            }
            //  同理，p和q都比root值大，则最近公共祖先肯定在右子树上，tmp = tmp.right
            if (p.val > tmp.val && q.val > tmp.val) {
                tmp = tmp.right;
                continue;
            }
            // 大的在左子树，小的在右子树，则当前节点就是最近公共祖先
            return tmp;
        }

    }
}
