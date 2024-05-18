package tree.binary_tree;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Desc: 二叉树的遍历（前序、中序、后序、层序）
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午11:30
 */
public class BinaryTreeTraverseTest {

    @Test
    public void testPreOrder() {
        BinaryTreeNode root = initBinaryTree();
        List<Integer> preOrderResults = preOrder(root);
        Assert.assertEquals(toString(preOrderResults), "12489510367");
    }

    @Test
    public void testPreOrderStack() {
        BinaryTreeNode root = initBinaryTree();
        List<Integer> preOrderResults = preOrderStack(root);
        Assert.assertEquals(toString(preOrderResults), "12489510367");
    }

    @Test
    public void testInOrder() {
        BinaryTreeNode root = initBinaryTree();
        List<Integer> inOrderResults = inOrder(root);
        Assert.assertEquals(toString(inOrderResults), "84921051637");
    }

    // 非递归前序遍历
    @Test
    public void testInOrderStack() {
        BinaryTreeNode root = initBinaryTree();
        List<Integer> preOrderResult = inOrderStack(root);
        Assert.assertEquals(toString(preOrderResult), "84921051637");
    }

    @Test
    public void testPostOrder() {
        BinaryTreeNode root = initBinaryTree();
        List<Integer> postOrderResults = postOrder(root);
        Assert.assertEquals(toString(postOrderResults), "89410526731");
    }

    @Test
    public void testPostOrderStack() {
        BinaryTreeNode root = initBinaryTree();
        List<Integer> postOrderResults = postOrderStack(root);
        Assert.assertEquals(toString(postOrderResults), "89410526731");
    }

    @Test
    public void testLevelOrder() {
        BinaryTreeNode root = initBinaryTree();
        List<Integer> levelOrderResults = levelOrder(root);
        Assert.assertEquals(toString(levelOrderResults), "12345678910");
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
        List<Integer> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode poll = queue.poll();
                if (poll != null) {
                    result.add(poll.getVal());
                    if (Objects.nonNull(poll.getLeft())) {
                        queue.offer(poll.getLeft());
                    }
                    if (Objects.nonNull(poll.getRight())) {
                        queue.offer(poll.getRight());
                    }
                }
            }
        }
        return result;
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
