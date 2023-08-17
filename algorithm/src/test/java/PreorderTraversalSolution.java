import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * 前序遍历
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class PreorderTraversalSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        PreorderTraversalSolution solution = new PreorderTraversalSolution();
        System.out.println(solution.preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        results.add(root.val);
        results.addAll(preorderTraversal(root.left));
        results.addAll(preorderTraversal(root.right));
        return results;
    }
}
