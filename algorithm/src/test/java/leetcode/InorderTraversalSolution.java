package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/submissions/
 * 中序遍历
 * @author lichuangjian
 * @date 2023/6/12
 */
public class InorderTraversalSolution {


    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2, left, null);
        TreeNode treeNode = new TreeNode(1, null, right);
        InorderTraversalSolution solution = new InorderTraversalSolution();
//        List<Integer> integers = solution.inorderTraversal(treeNode);
        List<Integer> integers = solution.inorderTraversal(new TreeNode(1));
        System.out.println(integers);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        // 遍历左子树
        results.addAll(inorderTraversal(root.left));
        // 遍历根节点
        results.add(root.val);
        // 遍历右子树
        results.addAll(inorderTraversal(root.right));
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
