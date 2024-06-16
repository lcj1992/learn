package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode create(Integer... levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1; // Start from the first element after the root
        while (i < levelOrder.length) {
            TreeNode current = queue.poll();

            // Add left child
            if (levelOrder[i] != null) {
                current.left = new TreeNode(levelOrder[i]);
                queue.offer(current.left);
            }
            i++;

            // Add right child if it exists
            if (i < levelOrder.length && levelOrder[i] != null) {
                current.right = new TreeNode(levelOrder[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}