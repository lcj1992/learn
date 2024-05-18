package leetcode;

import common.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSublistsSolution {
    @Test
    public void testRemoveZeroSumSublits() {
        ListNode listNode = ListNode.createFromArray(new int[]{1, 2, -3, 3, 1});
        ListNode newListNode = removeZeroSumSublists(listNode);
        ListNode.print(newListNode);
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        int currentSum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> prefixSumMap = new HashMap<>();

        ListNode node = dummy;
        while (node != null) {
            currentSum += node.getVal();
            prefixSumMap.put(currentSum, node);
            node = node.next;
        }
        node = dummy;
        currentSum = 0;
        while (node != null) {
            currentSum += node.getVal();
            node.next = prefixSumMap.get(currentSum).next;
            node = node.next;
        }
        return dummy.next;
    }
}
