package tree.binary_tree;

import com.google.common.collect.Lists;
import common.TreeNode;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * 1. 二叉树的遍历（前序、中序、后序、层序）
 * 2. 统计所有非叶子节点的和
 */
public class BinaryTreeTraversalTest {

    /**
     * 树的遍历
     * 前序遍历：根左右
     * 中序遍历：左根右
     * 后序遍历：左右根
     */
    @Test
    public void testTraversal() {
        TreeNode root = initBinaryTree();
        List<Integer> results;
        // 前序遍历，根左右
        results = preOrder(root);
        assertEquals(toString(results), "12489510367");
        results = preOrderStack(root);
        assertEquals(toString(results), "12489510367");

        // 中序遍历，左根右
        results = inOrder(root);
        assertEquals(toString(results), "84921051637");
        results = inOrderStack(root);
        assertEquals(toString(results), "84921051637");

        // 后序遍历，左右根
        results = postOrder(root);
        assertEquals(toString(results), "89410526731");
        results = postOrderStack(root);
        assertEquals(toString(results), "89410526731");
        
    }

    @Test
    public void testIsValidBST() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        assertFalse(isValidBST(treeNode));
    }

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


    /**
     * <a href="https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/">...</a>
     * 判断一个树是否是另一棵的子树
     */
    @Test
    public void testSubTree() {
        TreeNode root = initBinaryTree();
        TreeNode subTree = initSubTree();
        boolean result = isSubTree(root, subTree);
        System.out.println(result);

    }


    private List<Integer> preOrder(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.add(root.val);
        result.addAll(preOrder(root.left));
        result.addAll(preOrder(root.right));
        return result;
    }

    private List<Integer> preOrderStack(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (Objects.nonNull(pop.right)) {
                stack.push(pop.right);
            }
            if (Objects.nonNull(pop.left)) {
                stack.push(pop.left);
            }
        }
        return result;
    }

    private List<Integer> inOrder(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }

    private List<Integer> inOrderStack(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }


    private List<Integer> postOrder(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(postOrder(root.left));
        result.addAll(postOrder(root.right));
        result.add(root.val);
        return result;
    }

    private List<Integer> postOrderStack(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (current.right == null || current.right == lastVisited) {
                stack.pop();
                result.add(current.val);
                lastVisited = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        return result;
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

    private boolean sub(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null || !Objects.equals(tree1.val, tree2.val)) {
            return false;
        }
        return sub(tree1.left, tree2.left) && sub(tree1.right, tree2.right);
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

    private boolean isSubTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null) {
            return true;
        }
        if (sub(tree1, tree2)) {
            return true;
        }
        return isSubTree(tree1.left, tree2) || isSubTree(tree1.right, tree2);
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

    private String toString(List<Integer> preOrderResults) {
        return preOrderResults.stream().map(Object::toString).collect(Collectors.joining());
    }
}
