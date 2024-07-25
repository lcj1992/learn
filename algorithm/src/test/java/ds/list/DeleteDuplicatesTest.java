package ds.list;

import common.ListNode;
import common.Utils;
import org.junit.Test;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">...</a>
 *
 * @author lichuangjian
 * @date 2023/8/9
 */
public class DeleteDuplicatesTest {

    @Test
    public void test() {
        ListNode res = deleteDuplicates(ListNode.createFromArray(1, 1, 2, 3, 3));
        Utils.print(res);
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
}
