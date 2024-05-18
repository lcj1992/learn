package leetcode;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * 环形链表
 *
 * @author lichuangjian
 * @date 2023/8/17
 */
public class HasCycleSolution {

    public static void main(String[] args) {
        HasCycleSolution solution = new HasCycleSolution();
        ListNode oneNode = new ListNode(3);
        ListNode twoNode = new ListNode(2);
        ListNode threeNode = new ListNode(0);
        ListNode fourNode = new ListNode(-4);
        oneNode.next = twoNode;
        twoNode.next = threeNode;
        threeNode.next = fourNode;
        fourNode.next = twoNode;

        boolean res = solution.hasCycle(oneNode);
        System.out.println(res);
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> existNodes = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            boolean add = existNodes.add(temp);
            if (!add) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
