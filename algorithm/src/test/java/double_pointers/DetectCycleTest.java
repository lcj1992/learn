package double_pointers;

import common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&envId=selected-coding-interview">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class DetectCycleTest {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
