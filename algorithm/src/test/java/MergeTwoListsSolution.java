import java.util.Objects;

/**
 * @author lichuangjian
 * @date 2023/6/17
 */
public class MergeTwoListsSolution {

    public static void main(String[] args) {
        MergeTwoListsSolution solution = new MergeTwoListsSolution();
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2, l13);
        ListNode l1 = new ListNode(1, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3, l23);
        ListNode l2 = new ListNode(1, l22);
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (Objects.nonNull(listNode)) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1)) {
            return list2;
        }
        if (Objects.isNull(list2)) {
            return list1;
        }
        // 初始化第一个节点
        ListNode head;

        if (list1.val < list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode temp = head;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            int l1Val = list1.val;
            int l2Val = list2.val;
            if (l1Val < l2Val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (Objects.isNull(list1)) {
            temp.next = list2;
        }
        if (Objects.isNull(list2)) {
            temp.next = list1;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
