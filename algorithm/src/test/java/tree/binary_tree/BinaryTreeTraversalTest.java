package tree.binary_tree;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
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
        BiTreeNode root = initBinaryTree();
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

        // 层序遍历
        results = levelOrder(root);
        assertEquals(toString(results), "12345678910");
        results = levelOrderStack(root);
        assertEquals(toString(results), "12345678910");
    }

    @Test
    public void testIsValidBST() {
        BiTreeNode treeNode = new BiTreeNode(5);
        treeNode.setLeft(new BiTreeNode(1));
        treeNode.setRight(new BiTreeNode(4));
        treeNode.getRight().setLeft(new BiTreeNode(3));
        treeNode.getRight().setRight(new BiTreeNode(6));
        assertFalse(isValidBST(treeNode));
    }

    @Test
    public void testMidNodeSum() {
        BiTreeNode root = initBinaryTree();
        Integer result = sumMidNode(root);
        System.out.println(result);
        result = sumMidNodeStack(root);
        System.out.println(result);
    }

    @Test
    public void testSameTree() {
        BiTreeNode root = initBinaryTree();
        BiTreeNode subTree = initSubTree();
        boolean sameTree = isSameTree(root, subTree);
        System.out.println(sameTree);
        sameTree = isSameTree(root, root);
        System.out.println(sameTree);
        sameTree = isSameTreeStack(root, subTree);
        System.out.println(sameTree);
        sameTree = isSameTreeStack(root, root);
        System.out.println(sameTree);
    }

    @Test
    public void testSubTree() {
        BiTreeNode root = initBinaryTree();
        BiTreeNode subTree = initSubTree();
        boolean result = isSubTree(root, subTree);
        System.out.println(result);

    }


    private List<Integer> preOrder(BiTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.add(root.getVal());
        result.addAll(preOrder(root.getLeft()));
        result.addAll(preOrder(root.getRight()));
        return result;
    }

    private List<Integer> preOrderStack(BiTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BiTreeNode pop = stack.pop();
            result.add(pop.getVal());
            if (Objects.nonNull(pop.getRight())) {
                stack.push(pop.getRight());
            }
            if (Objects.nonNull(pop.getLeft())) {
                stack.push(pop.getLeft());
            }
        }
        return result;
    }

    private List<Integer> inOrder(BiTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(inOrder(root.getLeft()));
        result.add(root.getVal());
        result.addAll(inOrder(root.getRight()));
        return result;
    }

    private List<Integer> inOrderStack(BiTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            result.add(current.getVal());
            current = current.getRight();
        }
        return result;
    }


    private List<Integer> postOrder(BiTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(postOrder(root.getLeft()));
        result.addAll(postOrder(root.getRight()));
        result.add(root.getVal());
        return result;
    }

    private List<Integer> postOrderStack(BiTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode current = root;
        BiTreeNode lastVisited = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.peek();
            if (current.getRight() == null || current.getRight() == lastVisited) {
                stack.pop();
                result.add(current.getVal());
                lastVisited = current;
                current = null;
            } else {
                current = current.getRight();
            }
        }
        return result;
    }

    private List<Integer> levelOrder(BiTreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<BiTreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        return levelOrder(nodeList);
    }

    private List<Integer> levelOrder(List<BiTreeNode> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        List<BiTreeNode> newList = new ArrayList<>();
        for (BiTreeNode binaryTreeNode : nodeList) {
            results.add(binaryTreeNode.getVal());
            if (binaryTreeNode.getLeft() != null) {
                newList.add(binaryTreeNode.getLeft());
            }
            if (binaryTreeNode.getRight() != null) {
                newList.add(binaryTreeNode.getRight());
            }
        }
        results.addAll(levelOrder(newList));
        return results;
    }

    private List<Integer> levelOrderStack(BiTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<List<BiTreeNode>> stack = new Stack<>();
        List<BiTreeNode> list = new ArrayList<>();
        list.add(root);
        stack.push(list);
        while (!stack.isEmpty()) {
            List<BiTreeNode> pops = stack.pop();
            List<BiTreeNode> newList = new ArrayList<>();
            if (pops != null && !pops.isEmpty()) {
                for (BiTreeNode pop : pops) {
                    result.add(pop.getVal());
                    if (Objects.nonNull(pop.getLeft())) {
                        newList.add(pop.getLeft());
                    }
                    if (Objects.nonNull(pop.getRight())) {
                        newList.add(pop.getRight());
                    }
                }
                stack.push(newList);
            }
        }
        return result;
    }

    private boolean isValidBST(BiTreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(BiTreeNode root, long min, long max) {
        if (Objects.isNull(root)) {
            return true;
        }
        int val = root.getVal();
        if (val >= max || val <= min) {
            return false;
        }
        return isValidBST(root.getLeft(), min, val) && isValidBST(root.getRight(), val, max);
    }

    private Integer sumMidNode(BiTreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }
        return sumMidNode(node.getLeft()) + sumMidNode(node.getRight()) + node.getVal();
    }

    private Integer sumMidNodeStack(BiTreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        Stack<BiTreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BiTreeNode pop = stack.pop();
            if (pop.getLeft() == null && pop.getRight() == null) {
                sum += 0;
            } else {
                sum += pop.getVal();
                if (pop.getRight() != null) {
                    stack.push(pop.getRight());
                }
                if (pop.getLeft() != null) {
                    stack.push(pop.getLeft());
                }
            }
        }
        return sum;
    }

    private boolean sub(BiTreeNode tree1, BiTreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null || !Objects.equals(tree1.val, tree2.val)) {
            return false;
        }
        return sub(tree1.left, tree2.left) && sub(tree1.right, tree2.right);
    }

    private boolean isSameTree(BiTreeNode tree1, BiTreeNode tree2) {
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

    public boolean isSameTreeStack(BiTreeNode tree1, BiTreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree2 == null) {
            return false;
        }
        Stack<BiTreeNode> stack1 = new Stack<>();
        Stack<BiTreeNode> stack2 = new Stack<>();
        stack1.push(tree1);
        stack2.push(tree2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            BiTreeNode pop1 = stack1.pop();
            BiTreeNode pop2 = stack2.pop();
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

    private boolean isSubTree(BiTreeNode tree1, BiTreeNode tree2) {
        if (tree1 == null || tree2 == null) {
            return true;
        }
        if (sub(tree1, tree2)) {
            return true;
        }
        return isSubTree(tree1.getLeft(), tree2) || isSubTree(tree1.getRight(), tree2);
    }


    private BiTreeNode initBinaryTree() {
        BiTreeNode node10 = new BiTreeNode(10);
        BiTreeNode node9 = new BiTreeNode(9);
        BiTreeNode node8 = new BiTreeNode(8);
        BiTreeNode node7 = new BiTreeNode(7);
        BiTreeNode node6 = new BiTreeNode(6);
        BiTreeNode node5 = new BiTreeNode(5, node10, null);
        BiTreeNode node4 = new BiTreeNode(4, node8, node9);
        BiTreeNode node3 = new BiTreeNode(3, node6, node7);
        BiTreeNode node2 = new BiTreeNode(2, node4, node5);
        return new BiTreeNode(1, node2, node3);
    }

    private BiTreeNode initSubTree() {
        BiTreeNode node9 = new BiTreeNode(9);
        BiTreeNode node8 = new BiTreeNode(8);
        BiTreeNode node7 = new BiTreeNode(7);
        BiTreeNode node6 = new BiTreeNode(6);
        BiTreeNode node4 = new BiTreeNode(4, node8, node9);
        BiTreeNode node3 = new BiTreeNode(3, node6, node7);
        BiTreeNode node2 = new BiTreeNode(2, node4, null);
        return new BiTreeNode(1, node2, node3);
    }

    private String toString(List<Integer> preOrderResults) {
        return preOrderResults.stream().map(Object::toString).collect(Collectors.joining());
    }
}
