package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author lichuangjian
 * @date 2023/6/21
 */
public class LevelOrderSolution {

    public static void main(String[] args) {
        LevelOrderSolution solution = new LevelOrderSolution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> rootLevel = new ArrayList<>();
        rootLevel.add(root.val);
        results.add(rootLevel);
        if (Objects.nonNull(root.right)) {
            stack.push(root.right);
        }
        if (Objects.nonNull(root.left)) {
            stack.push(root.left);
        }
        while (!stack.isEmpty()) {
            List<TreeNode> oneLevelNodes = new ArrayList<>();
            List<Integer> oneLevelResult = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                oneLevelResult.add(pop.val);
                oneLevelNodes.add(pop);
            }
            results.add(oneLevelResult);
            for (int i = oneLevelNodes.size() - 1; i >= 0; i--) {
                TreeNode node = oneLevelNodes.get(i);
                if (Objects.nonNull(node.right)) {
                    stack.push(node.right);
                }
                if (Objects.nonNull(node.left)) {
                    stack.push(node.left);
                }
            }

        }
        return results;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}





