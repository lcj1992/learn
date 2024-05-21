package tree.binary_tree;

import common.TreeNode;

import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/6/12
 */
public class IsValidBSTSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null), new TreeNode(47, null, new TreeNode(56)));
        IsValidBSTSolution solution = new IsValidBSTSolution();
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        boolean leftIsValid = Objects.isNull(root.left) || (isValidLeft(root.left, root.val) && isValidBST(root.left));
        boolean rightIsValid = Objects.isNull(root.right) || isValidRight(root.right, root.val) && isValidBST(root.right);
        return leftIsValid && rightIsValid;
    }

    private boolean isValidRight(TreeNode rightChild, int val) {
        if (Objects.isNull(rightChild)) {
            return true;
        }
        if (rightChild.val <= val) {
            return false;
        }
        return isValidRight(rightChild.right, val) && isValidRight(rightChild.left, val);
    }

    private boolean isValidLeft(TreeNode leftChild, int val) {
        if (Objects.isNull(leftChild)) {
            return true;
        }
        if (leftChild.val >= val) {
            return false;
        }
        return isValidLeft(leftChild.right, val) && isValidLeft(leftChild.left, val);
    }

}
