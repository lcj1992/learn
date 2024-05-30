package linear.linked_list;

import common.ListNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/UHnkqh/">...</a>
 * 描述：反转链表
 * 解题思路：反转过程中注意赋值的顺序
 *
 * @author lichuangjian
 * @date 2023/8/15
 */
public class ReverseListTest {

    @Test
    public void test() {
        ListNode listNode = reverseList(ListNode.createFromArray(1, 2, 3, 4, 5));
        ListNode.print(listNode);
        System.out.println();
        listNode = reverseList2(ListNode.createFromArray(1, 2, 3, 4, 5));
        ListNode.print(listNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

}
