package ds.list;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/15
 * Time: 下午4:30
 */
public class MaxSizeTest {

    public ListNode getReserveIdxNode(ListNode listNode, int reserveIdx) {
        int size = getListSize(listNode);

        int idx = size - reserveIdx + 1;

        size = 0;
        ListNode tmp = listNode;
        while (Objects.nonNull(tmp)) {
            if (size == idx) {
                return tmp;
            }
            size++;
        }
        return null;
    }

    private int getListSize(ListNode listNode) {
        int size = 0;
        ListNode tmp = listNode;
        while (Objects.nonNull(tmp)) {
            size++;
            tmp = tmp.getNext();
        }
        return size;
    }

    @Test
    public void test1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode reserveIdxNode = getReserveIdxNode(listNode1, 3);

        Assert.assertEquals(getListSize(listNode1), 4);
        Assert.assertEquals(getListSize(listNode2), 3);
        Assert.assertEquals(reserveIdxNode.getVal(), 2);
    }
}
