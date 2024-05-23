package linear.linked_list;

import common.ListNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/">...</a>
 * 描述：间隔k位反转链表，包含间隔2位反转链表
 * 解题思路：
 * 1. 每k个节点一组，逐组进行反转
 * 2. 将多组拼接起来
 */
public class ReverseKGroupTest {

    @Test
    public void testReverseKGroup() {
        ListNode listNode = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode listNode1 = reverseKGroup(listNode, 3);
        ListNode.print(listNode1);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // 反转 k 个节点
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            // 连接反转后的链表
            ListNode temp = groupPrev.next; // 记录反转前的第一个节点
            groupPrev.next = kth; // 反转后的第一个节点
            temp.next = groupNext; // 连接到下一个未反转的节点

            groupPrev = temp; // 更新 groupPrev 为反转后的第一个节点
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
