package double_pointers;

import common.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">...</a>
 * 相交链表
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class GetIntersectionNodeTest {

    @Test
    public void test() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        ListNode intersectionNode = getIntersectionNode2(node1, node6);
        System.out.println(intersectionNode.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> headAIndexMap = new HashMap<>();
        int i = 0;
        ListNode temp = headA;
        while (temp != null) {
            headAIndexMap.put(temp, i++);
            temp = temp.next;
        }
        ListNode temp2 = headB;
        while (temp2 != null) {
            if (headAIndexMap.containsKey(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // 两次遍历最终会在交汇点重合
        while (nodeA != nodeB) {
            // 先遍历A链表，后遍历B链表
            nodeA = nodeA != null ? nodeA.next : headB;
            // 先遍历B链表，后遍历A链表
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        return nodeA;
    }
}
