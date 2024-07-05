package ds.tree.binary_tree;

import common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 **/
public class TreeToDoublyListTest {


    // 最小(第一个)和最大(最后一个)节点
    TreeNode first = null;
    TreeNode last = null;

    public void helper(TreeNode node) {
        if (node != null) {
            // 左子树
            helper(node.left);
            if (last != null) {
                // 链接前一个节点(最后一个)
                // 使用当前节点
                last.right = node;
                node.left = last;
            } else {
                // 保留最小的节点
                // 稍后关闭 DLL
                first = node;
            }
            last = node;
            // 右子树
            helper(node.right);
        }
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        helper(root);
        // 关闭 DLL
        last.right = first;
        first.left = last;
        return first;
    }
}
