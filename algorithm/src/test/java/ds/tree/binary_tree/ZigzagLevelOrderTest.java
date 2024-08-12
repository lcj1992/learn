package ds.tree.binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">...</a>
 * 二叉树的锯齿形层序遍历
 *
 * @author foolchid
 * @date 2024/5/29
 * today
 **/
public class ZigzagLevelOrderTest {

    @Test
    public void test() {
        List<List<Integer>> lists = zigzagLevelOrder(TreeNode.create(3, 9, 20, null, null, 15, 7));
        System.out.println(lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        List<List<Integer>> results = new ArrayList<>();
        boolean fromLeft = false;
        while (!deque.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                if (fromLeft) {
                    levelList.addFirst(node.val);
                } else {
                    levelList.addLast(node.val);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            results.add(new ArrayList<>(levelList));
            fromLeft = !fromLeft;
        }
        return results;
    }

}
