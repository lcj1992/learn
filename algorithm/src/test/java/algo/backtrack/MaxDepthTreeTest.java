package algo.backtrack;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">...</a>
 * <p>
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/15
 * Time: 上午10:24
 */
public class MaxDepthTreeTest {

    @Test
    public void test() throws Exception {
        int i = maxDepth(TreeNode.create(3, 9, 20, null, null, 15, 7));
        Assert.assertEquals(i, 3);
        i = maxDepth2(TreeNode.create(3, 9, 20, null, null, 15, 7));
        Assert.assertEquals(i, 3);
    }

    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return res;
    }


}
