package algo.double_pointers;

import common.ListNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">...</a>
 * 环形链表
 * 思路：快慢指针
 * 龟速度为1，兔速度为2，那么当龟兔都进入环时，龟领先兔的距离为x，它们的相对速度为1，赶上的时间t满足：x=(2-1) * t。
 * 一圈有n个节点，那么兔终将在经历m圈(m>=0)后后赶上龟，m=t/(n/2)
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class HasCycleTest {

    @Test
    public void test() {
        ListNode oneNode = new ListNode(3);
        ListNode twoNode = new ListNode(2);
        ListNode threeNode = new ListNode(0);
        ListNode fourNode = new ListNode(-4);
        oneNode.next = twoNode;
        twoNode.next = threeNode;
        threeNode.next = fourNode;
        fourNode.next = twoNode;

        boolean res = hasCycle(oneNode);
        System.out.println(res);
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
