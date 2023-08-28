package common;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode createFromArray(int[] nums) {
        int first = nums[0];
        ListNode head = new ListNode(first);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return head;
    }
}