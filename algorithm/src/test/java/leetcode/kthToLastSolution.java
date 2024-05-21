package leetcode;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class kthToLastSolution {

    @Test
    public void testKthToLast() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        int result = kthToLast(node1, 2);
        Assert.assertEquals(result, 4);
    }


    public int kthToLast(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre.val;
    }

    public int kthToLast2(ListNode head, int k) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            map.put(index++, temp);
            temp = temp.getNext();
        }
        return map.get(index - k).getVal();
    }
}
