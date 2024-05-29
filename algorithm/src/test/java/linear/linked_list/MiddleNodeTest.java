package linear.linked_list;

import common.ListNode;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/?envType=study-plan-v2&envId=selected-coding-interview">...</a>
 * 链表的中间节点
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class MiddleNodeTest {


    @Test
    public void test() {
        ListNode listNode = middleNode(ListNode.createFromArray(1, 2, 2, 3, 4, 5));
        System.out.println(listNode.val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
