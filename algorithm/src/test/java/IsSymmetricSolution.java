import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/8/2
 */
public class IsSymmetricSolution {

    public static void main(String[] args) {
        IsSymmetricSolution solution = new IsSymmetricSolution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean symmetric = solution.isSymmetric(root2);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (Objects.nonNull(left.right) && Objects.nonNull(right.left) && left.right.val != right.left.val) {
            return false;
        }
        if (Objects.nonNull(left.left) && Objects.nonNull(right.right) && left.left.val != right.right.val) {
            return false;
        }
        if (!isSymmetric(left.left, right.right)) {
            return false;
        }
        if (!isSymmetric(left.right, right.left)) {
            return false;
        }
        return true;
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
