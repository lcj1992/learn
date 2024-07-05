package ds.list;

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

    /**
     * 思路：
     * 1. 整两个链表，一个记录大于等于x的large，一个记录小于x的small
     * 2. 遍历链表，分别调整large和small的指针
     * 3. 拼接两个链表
     */
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
        // 注意这里要赋值large.next，否则可能出现循环链表
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
