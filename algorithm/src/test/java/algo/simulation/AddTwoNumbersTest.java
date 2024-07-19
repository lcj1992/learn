package algo.simulation;


import common.ListNode;
import common.Utils;
import org.junit.Test;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">...</a>
 *
 * @author lichuangjian
 * @date 2023/6/4
 */
public class AddTwoNumbersTest {

    @Test
    public void test() {
        ListNode listNode = addTwoNumbers(ListNode.createFromArray(2, 4, 3), ListNode.createFromArray(5, 6, 4));
        Utils.printListNode(listNode);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = null;
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
