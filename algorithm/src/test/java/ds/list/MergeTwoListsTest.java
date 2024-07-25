package ds.list;

import common.ListNode;
import common.Utils;
import org.junit.Test;

import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">...</a>
 * 合并两个有序链表
 *
 * @author lichuangjian
 * @date 2023/6/17
 */
public class MergeTwoListsTest {

    @Test
    public void test() {
        ListNode l1 = ListNode.createFromArray(1, 2, 4);
        ListNode l2 = ListNode.createFromArray(1, 3, 4);
        ListNode listNode = mergeTwoLists(l1, l2);
        Utils.print(listNode);
    }

    /**
     * 思路一：递归
     * 1. l1为空直接返回l2，l2为空同理
     * 2. 如果l1的头节点小于l2头节点，以l1作为首节点作为结果的头节点，递归l1.next，l2
     * 3. 如果l2的头节点小于l1头节点，同理
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1)) {
            return l2;
        }
        if (Objects.isNull(l2)) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

    /**
     * 思路二：迭代
     * 1. 引入伪头节点：建立一个伪头节点 dummy，并建立遍历节点cur
     * 2. l1的值小于l2的值，将temp的next指向l1，移动l1
     * 3. l2的值小于l1的值，同理
     * 4. 追加最终的没进行比较的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null ? l2 : l1);
        return dummy.next;
    }
}
