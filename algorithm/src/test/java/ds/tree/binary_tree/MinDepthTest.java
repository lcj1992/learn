package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/8/9
 */
public class MinDepthTest {

    @Test
    public void test(){
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        if (Objects.isNull(root.left)) {
            return 1 + minDepth(root.right);
        }
        if (Objects.isNull(root.right)) {
            return 1 + minDepth(root.left);
        }
        int leftResult = 1 + minDepth(root.left);
        int rightResult = 1 + minDepth(root.right);
        return Math.min(leftResult, rightResult);
    }


}
