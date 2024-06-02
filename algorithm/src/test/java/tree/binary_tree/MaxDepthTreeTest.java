package tree.binary_tree;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/15
 * Time: 上午10:24
 */
public class MaxDepthTreeTest {

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

    /**
     * 深度优先，DFS
     * 最大深度=max(左子树深度，右子树深度) + 1
     */
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    /**
     * 广度优先，BFS
     * 层序遍历，遍历一层，深度加1
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int res = 0;
        while (!list.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode : list) {
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }
            list = temp;
            res++;
        }
        return res;
    }


}
