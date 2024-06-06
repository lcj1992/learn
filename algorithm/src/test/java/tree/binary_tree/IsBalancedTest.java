package tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">...</a>
 *
 * @author lichuangjian
 * @date 2023/8/9
 */
public class IsBalancedTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        // 左右子树的高度小于等于 1
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // 左右子树也都是高度平衡
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight - rightHeight) <= 1;
    }

    private int height(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
