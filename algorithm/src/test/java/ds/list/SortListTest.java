package ds.list;


import common.ListNode;
import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/sort-list/">...</a>
 * 排序链表
 */
public class SortListTest {

    @Test
    public void test() {
        ListNode res = sortList(ListNode.createFromArray(4, 2, 3, 1));
        Utils.print(res);
    }

    public ListNode sortList(ListNode head) {
        // 0个元素，1个元素
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(tmp);
        return mergeTwoList(l1, l2);
    }

    private ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            int lv1 = l1.val;
            int lv2 = l2.val;
            if (lv1 < lv2) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null ? l1 : l2);
        return dummy.next;
    }

}
