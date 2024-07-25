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

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
