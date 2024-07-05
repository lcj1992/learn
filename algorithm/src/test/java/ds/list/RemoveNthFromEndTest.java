package ds.list;

import common.ListNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">...</a>
 * 描述：删除链表的倒数第 N 个结点
 * 思路：双指针
 *
 * @author foolchid
 * @date 2024/5/22
 **/
public class RemoveNthFromEndTest {

    @Test
    public void test() {
        ListNode listNode = ListNode.createFromArray(1, 2, 3, 4, 5);
        ListNode result = removeNthFromEnd(listNode, 2);
        ListNode.print(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

}
