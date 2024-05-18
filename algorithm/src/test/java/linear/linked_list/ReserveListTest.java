package linear.linked_list;

import com.google.common.base.Preconditions;
import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/18
 * Time: 下午4:11
 */
public class ReserveListTest {

    @Test
    public void test1() {
        // 1->2->3->4->5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode root = new ListNode(1, node2);
        Assert.assertEquals("43215", reserveSpecificIdx(root, 1, 4).toString());
    }

    @Test
    public void test2() {
        // 1->2->3->4->5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode root = new ListNode(1, node2);
        Assert.assertEquals(getSize(root), 5);
        Assert.assertEquals("14325", reserveSpecificIdx(root, 2, 4).toString());
    }

    @Test
    public void test3() {
        // 1->2->3->4->5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode root = new ListNode(1, node2);
        Assert.assertEquals("54321", reserveSpecificIdx(root, 1, 5).toString());
    }

    @Test
    public void test4() {
        // 1->2->3->4->5
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode root = new ListNode(1, node2);
        Assert.assertEquals("54321", reserve2(root).toString());
    }

    public ListNode reserveSpecificIdx(ListNode head, int idx1, int idx2) {
        Preconditions.checkArgument(idx1 >= 1);
        int size = getSize(head);
        Preconditions.checkArgument(idx2 <= size);
        if (idx1 == 1) {
            ListNode idx2Node = findIdxNode(head, idx2);
            ListNode tailList = idx2Node.getNext();
            idx2Node.setNext(null);
            ListNode reserve = reserve(head);
            head.setNext(tailList);
            return reserve;
        } else {
            ListNode idx1PreNode = findIdxNode(head, idx1 - 1);
            ListNode idx1Node = idx1PreNode.getNext();
            ListNode idx2Node = findIdxNode(head, idx2);
            ListNode tailList = idx2Node.getNext();

            idx2Node.setNext(null);
            ListNode reserve = reserve(idx1Node);

            idx1Node.setNext(tailList);
            idx1PreNode.setNext(reserve);
            return head;
        }
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (Objects.nonNull(tmp)) {
            size++;
            tmp = tmp.getNext();
        }
        return size;
    }

    public ListNode reserve(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode reHead = reserve(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

    public ListNode reserve2(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        ListNode tmp = head;
        while (Objects.nonNull(tmp.getNext())) {
            ListNode curNext = tmp.getNext();
            tmp.setNext(tmp.getNext().getNext());
            curNext.setNext(head);
            head = curNext;
        }
        return head;
    }

    private ListNode findIdxNode(ListNode tmp, int idx1) {
        for (int i = 0; Objects.nonNull(tmp); i++) {
            if (i == idx1 - 1) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

}
