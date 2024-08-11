package ds.list;

import common.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/">...</a>
 */
public class IsPalindromeTest {

    @Test
    public void test() {
        ListNode list = ListNode.createFromArray(1, 2, 2, 1);
        boolean res = isPalindrome(list);
        System.out.println(res);
        res = isPalindrome2(list);
        System.out.println(res);
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int l = 0;
        int r = vals.size() - 1;
        while (l <= r) {
            if (!vals.get(l).equals(vals.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // dummy      1    2    3    4    5
    // mid = 3;

    // dummy      1    2    3    4
    // mid = 3;
    public boolean isPalindrome2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode mid = middleNode(dummy);
        ListNode tmp = mid.next;
        ListNode p2 = reverse(tmp);
        ListNode p1 = head;
        while (p2 != null) {
            if (p2.val != p1.val) {
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }
}
