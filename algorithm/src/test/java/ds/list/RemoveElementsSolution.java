package ds.list;

import common.ListNode;

import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/8/24
 */
public class RemoveElementsSolution {

    public static void main(String[] args) {
        RemoveElementsSolution solution = new RemoveElementsSolution();
        ListNode input = ListNode.createFromArray(new int[]{1, 2, 2, 1});
        ListNode listNode = solution.removeElements(input, 2);
        ListNode.print(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        // 处理第一个节点
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        ListNode temp = head;
        while (temp != null) {
            if (Objects.isNull(temp.next)) {
                break;
            }
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
