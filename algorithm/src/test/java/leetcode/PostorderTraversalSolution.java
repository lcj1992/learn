package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * 后续遍历
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class PostorderTraversalSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        PostorderTraversalSolution solution = new PostorderTraversalSolution();
        System.out.println(solution.postorderTraversal(root2));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        results.addAll(postorderTraversal(root.left));
        results.addAll(postorderTraversal(root.right));
        results.add(root.val);
        return results;
    }
}
