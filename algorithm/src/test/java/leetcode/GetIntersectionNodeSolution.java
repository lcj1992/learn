package leetcode;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuangjian
 * @date 2023/8/17
 */
public class GetIntersectionNodeSolution {

    public static void main(String[] args) {
        ListNode oneNode = new ListNode(4);
        ListNode twoNode = new ListNode(1);
        ListNode threeNode = new ListNode(8);
        ListNode fourNode = new ListNode(4);
        ListNode fiveNode = new ListNode(5);
        oneNode.next = twoNode;
        twoNode.next = threeNode;
        threeNode.next = fourNode;
        fourNode.next = fiveNode;

        ListNode one2Node = new ListNode(5);
        ListNode two2Node = new ListNode(6);
        ListNode three2Node = new ListNode(1);
        one2Node.next = two2Node;
        two2Node.next = three2Node;
        three2Node.next = three2Node;
        GetIntersectionNodeSolution solution = new GetIntersectionNodeSolution();
        ListNode intersectionNode = solution.getIntersectionNode(oneNode, one2Node);
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
}
