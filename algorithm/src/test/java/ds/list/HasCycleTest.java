package ds.list;

import common.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">...</a>
 * 环形链表
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
        Set<ListNode> existNodes = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            boolean add = existNodes.add(temp);
            if (!add) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
