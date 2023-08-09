import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lichuangjian
 * @date 2023/8/9
 */
public class HasPathSumSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(11);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node1.left = node2;
        node5.left = node6;
        node5.right = node7;
        node7.right = node8;
        HasPathSumSolution solution = new HasPathSumSolution();

//        boolean b = solution.hasPathSum(root, 22);
        boolean b = solution.hasPathSum(new TreeNode(1, new TreeNode(2), null), 1);
        System.out.println(b);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        int sum = 0;
        List<Integer> allSum = calculateAllSum(root, sum);
        return allSum.contains(targetSum);
    }

    private List<Integer> calculateAllSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            List<Integer> result = new ArrayList<>();
            result.add(sum);
            return result;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            List<Integer> result = new ArrayList<>();
            result.add(root.val + sum);
            return result;
        }
        List<Integer> results = new ArrayList<>();
        if (Objects.nonNull(root.left)) {
            // 左子树的所有路径
            List<Integer> leftPaths = calculateAllSum(root.left, sum);
            List<Integer> leftResult = leftPaths.stream().map(leftSum -> leftSum + root.val).collect(Collectors.toList());
            results.addAll(leftResult);
        }
        // 右子树的所有路径
        if (Objects.nonNull(root.right)) {
            List<Integer> rightPaths = calculateAllSum(root.right, sum);
            List<Integer> rightResult = rightPaths.stream().map(leftSum -> leftSum + root.val).collect(Collectors.toList());
            results.addAll(rightResult);
        }

        return results;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return root.val == targetSum;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        List<List<TreeNode>> allPath = calculateAllPath(root);
        for (List<TreeNode> treeNodes : allPath) {
            int sum = 0;
            for (TreeNode treeNode : treeNodes) {
                sum += treeNode.val;
            }
            if (sum == targetSum) {
                return true;
            }
        }
        return false;
    }

    private List<List<TreeNode>> calculateAllPath(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            List<List<TreeNode>> result = new ArrayList<>();
            result.add(path);
            return result;
        }
        // 左子树的所有路径
        List<List<TreeNode>> leftPaths = calculateAllPath(root.left);
        for (List<TreeNode> path : leftPaths) {
            path.add(root);
        }

        // 右子树的所有路径
        List<List<TreeNode>> rightPaths = calculateAllPath(root.right);
        for (List<TreeNode> path : rightPaths) {
            path.add(root);
        }
        // merge
        List<List<TreeNode>> results = new ArrayList<>();
        results.addAll(leftPaths);
        results.addAll(rightPaths);
        return results;
    }

}
