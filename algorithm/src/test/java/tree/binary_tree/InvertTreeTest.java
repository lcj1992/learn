package tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">...</a>
 * 反转二叉树，也叫镜像二叉树
 *
 * @author foolchild
 * @date 2019/5/11
 */
public class InvertTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        TreeNode treeNode = invertTreeStack(root);
        System.out.println(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTreeStack(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode left = pop.left;
            TreeNode right = pop.right;
            pop.left = right;
            pop.right = left;
            if (Objects.nonNull(left)) {
                stack.push(left);
            }
            if (Objects.nonNull(right)) {
                stack.push(right);
            }
        }
        return root;
    }
}
