package linear.linked_list;

import common.ListNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/">...</a>
 * 描述：反转left和right之间的链表
 * 解题思路：
 * 1. 找到left的前缀位置
 * 2. 反转直至right位置
 *
 * @author foolchid
 * @date 2024/5/20
 **/
public class ReverseBetweenTest {

    @Test
    public void test() {
        // 1->2->3->4->5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode root = new ListNode(1, node2);
        ListNode listNode = reverseBetween(root, 2, 4);
        ListNode.print(listNode);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
