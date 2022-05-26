import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/15
 * Time: 上午10:24
 */
public class MaxDepthTreeTest {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        if (Objects.isNull(root.right) && Objects.isNull(root.left)) {
            return 1;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;
    }

    @Test
    public void test() throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = maxDepth(root);
        Assert.assertEquals(i, 3);

    }
}
