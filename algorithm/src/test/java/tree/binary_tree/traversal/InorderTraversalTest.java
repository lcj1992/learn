package tree.binary_tree.traversal;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">...</a>
 * 中序遍历： 左根右
 *
 * @author lichuangjian
 * @date 2023/6/12
 */
public class InorderTraversalTest {


    @Test
    public void test() {
        TreeNode root = TreeNode.buildTree(1, null, 2, 3);
        List<Integer> integers = inorderTraversal(root);
        System.out.println(integers);
        integers = inorderTraversalStack(root);
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

    public List<Integer> inorderTraversalStack(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        TreeNode current = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> results = new ArrayList<>();
        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.addFirst(current);
                current = current.left;
            }
            current = deque.removeFirst();
            results.add(current.val);
            current = current.right;
        }
        return results;
    }
}
