package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/19
 * Time: 上午9:27
 */
public class MergeListsTest {

    // 归并排序
    @Test
    public void test() {
        ListNode list1 = initList(1, 4, 5);
        ListNode list2 = initList(1, 3, 4);
        ListNode list3 = initList(2, 6);
        ListNode[] param = new ListNode[]{list1, list2, list3};
        ListNode listNode = mergeKLists(param);
        Assert.assertEquals(listNode.toString(), "11234456");
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }

    private ListNode initList(Integer... integers) {
        int length = integers.length;
        ListNode head = null;
        ListNode cur = null;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                head = new ListNode(integers[0]);
                cur = head;
            } else {
                ListNode listNode = new ListNode(integers[i]);
                cur.next = listNode;
                cur = listNode;
            }
        }
        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;


        ListNode(int x) {
            val = x;
        }

        public String toString() {
            if (Objects.isNull(this.next)) {
                return String.valueOf(val);
            }
            return val + next.toString();

        }
    }


}
