package ds.tree.binary_tree;

import common.Node;
import common.TreeNode;
import common.Utils;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">...</a>
 *
 * @author foolchid
 * @date 2024/5/29
 * today
 **/
public class TreeToDoublyListTest {


    @Test
    public void test() {
        TreeNode treeNode = treeToDoublyList(TreeNode.create(4, 2, 5, 1, 3));
        System.out.println(treeNode.val);
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode head = null;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null) {
                deque.addFirst(cur);
                cur = cur.left;
            }
            cur = deque.removeFirst();
            if (head == null) {
                head = cur;
            } else {
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}
