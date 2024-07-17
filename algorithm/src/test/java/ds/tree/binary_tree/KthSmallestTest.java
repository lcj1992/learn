package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class KthSmallestTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.create(5, 3, 6, 2, 4, null, null, 1);
        int res = kthSmallest(treeNode, 3);
        System.out.println(res);
    }

    /**
     * 二叉搜索数的中序遍历即是有序的
     * 每pop一个节点，k-1，当k==0时，即为第k小的节点
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.getFirst();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }


}
