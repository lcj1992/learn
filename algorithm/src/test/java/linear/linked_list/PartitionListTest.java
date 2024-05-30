package linear.linked_list;

import common.ListNode;
import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/partition-list/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class PartitionListTest {

    @Test
    public void test() {
        ListNode res = partition(ListNode.createFromArray(1, 4, 3, 2, 5, 2), 3);
        Utils.printListNode(res);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
