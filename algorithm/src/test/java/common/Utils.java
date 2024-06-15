package common;

import java.util.Objects;

/**
 * @author foolchid
 * @date 2024/5/22
 **/
public class Utils {
    public static void printArray(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return;
        }
        for (int anInt : arrays) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }

    public static void printListNode(ListNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        while (node != null) {
            System.out.print(node.val + (node.val > 10 ? " " : "  "));
            node = node.next;
        }
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
