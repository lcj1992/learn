package ds.list;

import common.ListNode;
import org.junit.Test;

import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/8/24
 */
public class RemoveElementsTest {

    @Test
    public void test() {
        ListNode input = ListNode.createFromArray(1, 2, 2, 1);
        ListNode listNode = removeElements(input, 2);
        ListNode.print(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
