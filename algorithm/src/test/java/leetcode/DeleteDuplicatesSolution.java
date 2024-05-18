package leetcode;

import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/8/9
 */
public class DeleteDuplicatesSolution {

    public static void main(String[] args) {
        DeleteDuplicatesSolution solution = new DeleteDuplicatesSolution();
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode listNode1 = solution.deleteDuplicates(listNode);
        while (Objects.nonNull(listNode1)) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode temp = head;
        while (Objects.nonNull(temp)) {
            int currentVal = temp.val;
            ListNode next = temp.next;
            if (Objects.nonNull(next) && next.val == currentVal) {
                temp.next = temp.next.next;
            } else {
                temp = next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
