package ds.list;

import common.ListNode;
import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/">...</a>
 * 描述：合并k个有序链表
 * 思路：
 *
 * @author lichuangjian
 * @date 2023/7/1
 */
public class MergeKListsTest {

    @Test
    public void test() {
        ListNode list1 = ListNode.createFromArray(1, 4, 5);
        ListNode list2 = ListNode.createFromArray(1, 3, 4);
        ListNode list3 = ListNode.createFromArray(2, 6);
        ListNode[] param = new ListNode[]{list1, list2, list3};
        ListNode listNode = mergeKLists(param);
        Utils.printListNode(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = null;
        for (ListNode list : lists) {
            res = mergeTwoLists(res, list);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            int lv1 = l1.val;
            int lv2 = l2.val;
            if (lv1 < lv2) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
