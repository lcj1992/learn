package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 *
 * 2. 统计所有非叶子节点的和
 */
public class BinaryTreeTraversalTest {

    @Test
    public void testMidNodeSum() {
        TreeNode root = initBinaryTree();
        Integer result = sumMidNode(root);
        System.out.println(result);
        result = sumMidNodeStack(root);
        System.out.println(result);
    }

    @Test
    public void testSameTree() {
        TreeNode root = initBinaryTree();
        TreeNode subTree = initSubTree();
        boolean sameTree = isSameTree(root, subTree);
        System.out.println(sameTree);
        sameTree = isSameTree(root, root);
        System.out.println(sameTree);
        sameTree = isSameTreeStack(root, subTree);
        System.out.println(sameTree);
        sameTree = isSameTreeStack(root, root);
        System.out.println(sameTree);
    }


    private Integer sumMidNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return sumMidNode(node.left) + sumMidNode(node.right) + node.val;
    }

    private Integer sumMidNodeStack(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left == null && pop.right == null) {
                sum += 0;
            } else {
                sum += pop.val;
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
        return sum;
    }

    private boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree2 == null) {
            return false;
        }
        return Objects.equals(tree1.val, tree2.val) && isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }

    public boolean isSameTreeStack(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree2 == null) {
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(tree1);
        stack2.push(tree2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode pop1 = stack1.pop();
            TreeNode pop2 = stack2.pop();
            if (!Objects.equals(pop1.val, pop2.val)) {
                return false;
            }
            if (pop1.right == null && pop2.right != null) {
                return false;
            }
            if (pop1.right != null && pop2.right == null) {
                return false;
            }
            if (pop1.left == null && pop2.left != null) {
                return false;
            }
            if (pop1.left != null && pop2.left == null) {
                return false;
            }
            if (pop1.right != null) {
                stack1.push(pop1.right);
                stack2.push(pop2.right);
            }
            if (pop1.left != null) {
                stack1.push(pop1.left);
                stack2.push(pop2.left);
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }


    private TreeNode initBinaryTree() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node10, null);
        TreeNode node4 = new TreeNode(4, node8, node9);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        return new TreeNode(1, node2, node3);
    }

    private TreeNode initSubTree() {
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node8, node9);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, null);
        return new TreeNode(1, node2, node3);
    }

}
