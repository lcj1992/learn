package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author foolchid
 * @date 2024/5/22
 **/
public class Utils {
    public static void print(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return;
        }
        for (int anInt : arrays) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }

    public static void print(ListNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        ListNode tmp = node;
        while (tmp != null) {
            System.out.print(tmp.val + (tmp.val > 10 ? " " : "  "));
            tmp = tmp.next;
        }
    }

    public static void print(TreeNode treeNode) {
        List<Integer> res = traversal(treeNode);
        System.out.println(res);
    }

    public static void print(List<List<Integer>> list) {
        list.forEach(System.out::println);
    }

    private static List<Integer> traversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        res.addAll(traversal(root.left));
        res.addAll(traversal(root.right));
        return res;
    }

    public static void swap(int[] items, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
