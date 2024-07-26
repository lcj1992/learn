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

    // 4    2   3   1
    // fs
    //      s   f
    //          s       f

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null) {
            int lv = left.val;
            int rv = right.val;
            if (lv < rv) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left == null ? right : left);
        return dummy.next;
    }

}
