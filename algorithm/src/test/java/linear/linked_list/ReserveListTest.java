package linear.linked_list;

import com.google.common.base.Preconditions;
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
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node root = new Node(1, node2);
        Assert.assertEquals("43215", reserveSpecificIdx(root, 1, 4).toString());
    }

    @Test
    public void test2() {
        // 1->2->3->4->5
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node root = new Node(1, node2);
        Assert.assertEquals(getSize(root), 5);
        Assert.assertEquals("14325", reserveSpecificIdx(root, 2, 4).toString());
    }

    @Test
    public void test3() {
        // 1->2->3->4->5
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node root = new Node(1, node2);
        Assert.assertEquals("54321", reserveSpecificIdx(root, 1, 5).toString());
    }

    @Test
    public void test4() {
        // 1->2->3->4->5
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node root = new Node(1, node2);
        Assert.assertEquals("54321", reserve2(root).toString());
    }

    public Node reserveSpecificIdx(Node head, int idx1, int idx2) {
        Preconditions.checkArgument(idx1 >= 1);
        int size = getSize(head);
        Preconditions.checkArgument(idx2 <= size);
        if (idx1 == 1) {
            Node idx2Node = findIdxNode(head, idx2);
            Node tailList = idx2Node.getNext();
            idx2Node.setNext(null);
            Node reserve = reserve(head);
            head.setNext(tailList);
            return reserve;
        } else {
            Node idx1PreNode = findIdxNode(head, idx1 - 1);
            Node idx1Node = idx1PreNode.getNext();
            Node idx2Node = findIdxNode(head, idx2);
            Node tailList = idx2Node.getNext();

            idx2Node.setNext(null);
            Node reserve = reserve(idx1Node);

            idx1Node.setNext(tailList);
            idx1PreNode.setNext(reserve);
            return head;
        }
    }

    private int getSize(Node head) {
        int size = 0;
        Node tmp = head;
        while (Objects.nonNull(tmp)) {
            size++;
            tmp = tmp.getNext();
        }
        return size;
    }

    public Node reserve(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node reHead = reserve(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

    public Node reserve2(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            return head;
        }
        Node tmp = head;
        while (Objects.nonNull(tmp.getNext())) {
            Node curNext = tmp.getNext();
            tmp.setNext(tmp.getNext().getNext());
            curNext.setNext(head);
            head = curNext;
        }
        return head;
    }

    private Node findIdxNode(Node tmp, int idx1) {
        for (int i = 0; Objects.nonNull(tmp); i++) {
            if (i == idx1 - 1) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            if (Objects.isNull(this.getNext())) {
                return String.valueOf(value);
            }
            return value + next.toString();
        }
    }
}
