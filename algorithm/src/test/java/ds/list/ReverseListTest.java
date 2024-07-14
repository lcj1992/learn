package ds.list;

import common.ListNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/UHnkqh/">...</a>
 * 反转链表
 *
 * @author lichuangjian
 * @date 2023/8/15
 */
public class ReverseListTest {

    @Test
    public void test() {
        ListNode listNode = reverseList(ListNode.createFromArray(1, 2, 3, 4, 5));
        ListNode.print(listNode);
        listNode = reverseList2(ListNode.createFromArray(1, 2, 3, 4, 5));
        ListNode.print(listNode);
        listNode = reverseList3(ListNode.createFromArray(1, 2, 3, 4, 5));
        ListNode.print(listNode);
    }

    /**
     * 思路一：迭代
     * 反转过程中注意赋值的顺序
     */
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

    /**
     * 迭代二
     * 引入伪头节点
     * 反转过程中注意赋值的顺序
     */
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

    /**
     * 递归
     * 逻辑和思路一的迭代方式是一样的
     */
    public ListNode reverseList3(ListNode head) {
        return recur(head, null);
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre; // 终止条件
        }
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

}
