package algo.backtrack;

import common.TreeNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/">...</a>
 * 路径总和3
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class PathSum3Test {

    @Test
    public void test() {
        int res = pathSum(TreeNode.create(1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000), 0);
        System.out.println(res);
    }

    int res;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        rootSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void rootSum(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            res++;
        }
        rootSum(root.left, targetSum);
        rootSum(root.right, targetSum);
    }


}
