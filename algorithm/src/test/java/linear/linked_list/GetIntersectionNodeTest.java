package linear.linked_list;

import common.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">...</a>
 * 相交链表
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class GetIntersectionNodeTest {

    @Test
    public void test() {
        ListNode oneNode = ListNode.createFromArray(4, 1, 8, 4, 5);
        ListNode one2Node = ListNode.createFromArray(5, 6, 1);
        ListNode intersectionNode = getIntersectionNode(oneNode, one2Node);
        System.out.println(intersectionNode.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> headAIndexMap = new HashMap<>();
        int i = 0;
        ListNode temp = headA;
        while (temp != null) {
            headAIndexMap.put(temp, i++);
            temp = temp.next;
        }
        ListNode temp2 = headB;
        while (temp2 != null) {
            if (headAIndexMap.containsKey(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
