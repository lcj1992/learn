package tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/">...</a>
 * 判断一个树是否是另一棵的子树
 *
 * @author foolchid
 * @date 2024/6/6
 **/
public class IsSubStructureTest {

    @Test
    public void test() {
        TreeNode tree1 = TreeNode.buildTree(3, 6, 7, 1, 8);
        TreeNode tree2 = TreeNode.buildTree(6, 1);
        boolean res = isSubStructure(tree1, tree2);
        System.out.println(res);
    }

    public boolean isSubStructure(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (sub(tree1, tree2)) {
            return true;
        }
        return isSubStructure(tree1.left, tree2) || isSubStructure(tree1.right, tree2);
    }


    private boolean sub(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null || tree1.val != tree2.val) {
            return false;
        }
        return sub(tree1.left, tree2.left) && sub(tree1.right, tree2.right);
    }
}
