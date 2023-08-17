import common.ListNode;

import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/8/15
 */
public class ReverseListSolution {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        ReverseListSolution solution = new ReverseListSolution();
        ListNode listNode = solution.reverseList(first);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode newHead = head;
        ListNode temp = head;
        while (temp.next != null) {
            // 保留当前节点的后继节点，作为头节点
            head = temp.next;
            // 当前节点的后继节点置为后继节点的后继节点
            temp.next = temp.next.next;
            // 反转当前节点和后继节点的
            head.next = newHead;
            // 记录head
            newHead = head;
        }
        return newHead;
    }
}
