import junit.framework.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/14
 * Time: 下午11:54
 */
public class ValidBinarySearchTreeTest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (Objects.isNull(root)) {
            return true;
        }
        int val = root.val;
        if (val >= max || val <= min) {
            return false;
        }
        return isValidBST(root.left, min, val) && isValidBST(root.right, val, max);
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        Assert.assertEquals(isValidBST(treeNode), false);
    }
}
