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
    public void testPreOrder() throws Exception {
        BinaryTreeNode root = initBinaryTree();
        List<BinaryTreeNode> preOrderResults = preOrder(root);
        Assert.assertEquals(toString(preOrderResults), "12489510367");
    }

    @Test
    public void testPreOrderRecursively() throws Exception {
        BinaryTreeNode root = initBinaryTree();
        List<BinaryTreeNode> preOrderResults = preOrderRecursively(root);
        Assert.assertEquals(toString(preOrderResults), "12489510367");
    }

    @Test
    public void testInfixOrder() throws Exception {
        BinaryTreeNode root = initBinaryTree();
        List<BinaryTreeNode> infixOrderResults = infixOrder(root);
        Assert.assertEquals(toString(infixOrderResults), "84921051637");
    }

    // 非递归前序遍历
    @Test
    public void testInfixOrderNonRecursively() throws Exception {
        BinaryTreeNode root = initBinaryTree();
        List<BinaryTreeNode> preOrderResult = infixOrderNonRecursively(root);
        Assert.assertEquals(toString(preOrderResult), "84921051637");
    }

    @Test
    public void testPostOrder() throws Exception {
        BinaryTreeNode root = initBinaryTree();
        List<BinaryTreeNode> postOrderResults = postOrder(root);
        Assert.assertEquals(toString(postOrderResults), "89410526731");
    }

    @Test
    public void testLevelOrder() throws Exception {
        BinaryTreeNode root = initBinaryTree();
        List<BinaryTreeNode> levelOrderResults = levelOrder(root);
        Assert.assertEquals(toString(levelOrderResults), "12345678910");
    }


    private List<BinaryTreeNode> preOrder(BinaryTreeNode root) {
        List<BinaryTreeNode> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.add(root);
        result.addAll(preOrder(root.getLeft()));
        result.addAll(preOrder(root.getRight()));
        return result;
    }

    private List<BinaryTreeNode> preOrderRecursively(BinaryTreeNode root) {
        List<BinaryTreeNode> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();
            result.add(pop);
            if (Objects.nonNull(pop.getRight())) {
                stack.push(pop.getRight());
            }
            if (Objects.nonNull(pop.getLeft())) {
                stack.push(pop.getLeft());
            }
        }
        return result;
    }

    private List<BinaryTreeNode> infixOrder(BinaryTreeNode root) {
        List<BinaryTreeNode> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(infixOrder(root.getLeft()));
        result.add(root);
        result.addAll(infixOrder(root.getRight()));
        return result;
    }

    private List<BinaryTreeNode> infixOrderNonRecursively(BinaryTreeNode root) {
        List<BinaryTreeNode> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Map<BinaryTreeNode, Boolean> visitedMap = Maps.newHashMap();
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode topNode = stack.peek();
            BinaryTreeNode leftNode = topNode.getLeft();
            if (Objects.nonNull(leftNode) && !visitedMap.containsKey(leftNode)) {
                stack.push(leftNode);
            } else {
                BinaryTreeNode pop = stack.pop();
                result.add(pop);
                visitedMap.put(pop, true);
                BinaryTreeNode rightNode = pop.getRight();
                if (Objects.nonNull(rightNode)) {
                    stack.push(rightNode);
                }
            }
        }
        return result;
    }

    private List<BinaryTreeNode> postOrder(BinaryTreeNode root) {
        List<BinaryTreeNode> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        result.addAll(postOrder(root.getLeft()));
        result.addAll(postOrder(root.getRight()));
        result.add(root);
        return result;
    }

    private List<BinaryTreeNode> levelOrder(BinaryTreeNode root) {
        List<BinaryTreeNode> result = Lists.newArrayList();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode poll = queue.poll();
                result.add(poll);
                if (Objects.nonNull(poll.getLeft())) {
                    queue.offer(poll.getLeft());
                }
                if (Objects.nonNull(poll.getRight())) {
                    queue.offer(poll.getRight());
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

    private String toString(List<BinaryTreeNode> preOrderResults) {
        return preOrderResults.stream().map(each -> each.getVal().toString()).collect(Collectors.joining());
    }
}
