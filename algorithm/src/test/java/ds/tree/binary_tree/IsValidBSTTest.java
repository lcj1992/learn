package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/">...</a>
 * 验证二叉搜索树
 * @author lichuangjian
 * @date 2023/6/12
 */
public class IsValidBSTTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null), new TreeNode(47, null, new TreeNode(56)));
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 二叉搜索树的性质：
     * 1. 节点的左子树只包含 小于 当前节点的数。
     * 2. 节点的右子树只包含 大于 当前节点的数。
     * 3. 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

}
