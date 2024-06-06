package tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">...</a>
 * 二叉树的层序遍历
 *
 * @author lichuangjian
 * @date 2023/6/21
 */
public class LevelOrderTest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(1, 2, 3, 4, null, null, 5);
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(lists);
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        levelOrder(nodeList, results);
        return results;
    }

    private void levelOrder(List<TreeNode> nodeList, List<List<Integer>> results) {
        if (nodeList == null || nodeList.isEmpty()) {
            return;
        }
        List<Integer> result = new ArrayList<>();
        List<TreeNode> newList = new ArrayList<>();
        for (TreeNode binaryTreeNode : nodeList) {
            result.add(binaryTreeNode.val);
            if (binaryTreeNode.left != null) {
                newList.add(binaryTreeNode.left);
            }
            if (binaryTreeNode.right != null) {
                newList.add(binaryTreeNode.right);
            }
        }
        results.add(result);
        levelOrder(newList, results);
    }

    private List<List<Integer>> levelOrderStack(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (Objects.isNull(root)) {
            return results;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        queue.add(list);
        while (!queue.isEmpty()) {
            List<TreeNode> pops = queue.poll();
            List<TreeNode> newList = new ArrayList<>();
            if (pops != null && !pops.isEmpty()) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode pop : pops) {
                    result.add(pop.val);
                    if (Objects.nonNull(pop.left)) {
                        newList.add(pop.left);
                    }
                    if (Objects.nonNull(pop.right)) {
                        newList.add(pop.right);
                    }
                }
                results.add(result);
                queue.add(newList);
            }
        }
        return results;
    }
}





