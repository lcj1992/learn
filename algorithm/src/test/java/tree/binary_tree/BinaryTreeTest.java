package tree.binary_tree;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Desc: 二叉树的遍历（前序、中序、后序、层序）
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午11:30
 */
public class BinaryTreeTest {

    /**
     * 树的遍历
     * 前序遍历：根左右
     * 中序遍历：左根右
     * 后序遍历：左右根
     */
    @Test
    public void testTraversal() {
        BinaryTreeNode root = initBinaryTree();
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
        BinaryTreeNode treeNode = new BinaryTreeNode(5);
        treeNode.setLeft(new BinaryTreeNode(1));
        treeNode.setRight(new BinaryTreeNode(4));
        treeNode.getRight().setLeft(new BinaryTreeNode(3));
        treeNode.getRight().setRight(new BinaryTreeNode(6));
        assertFalse(isValidBST(treeNode));

    }


    private List<Integer> preOrder(BinaryTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.add(root.getVal());
        result.addAll(preOrder(root.getLeft()));
        result.addAll(preOrder(root.getRight()));
        return result;
    }

    private List<Integer> preOrderStack(BinaryTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();
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

    private List<Integer> inOrder(BinaryTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(inOrder(root.getLeft()));
        result.add(root.getVal());
        result.addAll(inOrder(root.getRight()));
        return result;
    }

    private List<Integer> inOrderStack(BinaryTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
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


    private List<Integer> postOrder(BinaryTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(postOrder(root.getLeft()));
        result.addAll(postOrder(root.getRight()));
        result.add(root.getVal());
        return result;
    }

    private List<Integer> postOrderStack(BinaryTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        BinaryTreeNode lastVisited = null;
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

    private List<Integer> levelOrder(BinaryTreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<BinaryTreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        return levelOrder(nodeList);
    }

    private List<Integer> levelOrder(List<BinaryTreeNode> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        List<BinaryTreeNode> newList = new ArrayList<>();
        for (BinaryTreeNode binaryTreeNode : nodeList) {
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

    private List<Integer> levelOrderStack(BinaryTreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<List<BinaryTreeNode>> stack = new Stack<>();
        List<BinaryTreeNode> list = new ArrayList<>();
        list.add(root);
        stack.push(list);
        while (!stack.isEmpty()) {
            List<BinaryTreeNode> pops = stack.pop();
            List<BinaryTreeNode> newList = new ArrayList<>();
            if (pops != null && !pops.isEmpty()) {
                for (BinaryTreeNode pop : pops) {
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

    private boolean isValidBST(BinaryTreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(BinaryTreeNode root, long min, long max) {
        if (Objects.isNull(root)) {
            return true;
        }
        int val = root.getVal();
        if (val >= max || val <= min) {
            return false;
        }
        return isValidBST(root.getLeft(), min, val) && isValidBST(root.getRight(), val, max);
    }


    private BinaryTreeNode initBinaryTree() {
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node10, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, node8, node9);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        return new BinaryTreeNode(1, node2, node3);
    }

    private String toString(List<Integer> preOrderResults) {
        return preOrderResults.stream().map(Object::toString).collect(Collectors.joining());
    }
}
