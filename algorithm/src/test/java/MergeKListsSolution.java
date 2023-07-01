import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author lichuangjian
 * @date 2023/7/1
 */
public class MergeKListsSolution {
    public static void main(String[] args) {
        MergeKListsSolution solution = new MergeKListsSolution();
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] listNodes1 = new ListNode[]{list1, list2, list3};
        ListNode[] listNodes2 = new ListNode[]{new ListNode()};
        ListNode listNode = solution.mergeKLists(listNodes2);
        List<Integer> results = Lists.newArrayList();
        while (Objects.nonNull(listNode)) {
            results.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(results);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (Objects.isNull(lists) || lists.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode temp = null;
        Map<Integer, ListNode> cursorMap = new HashMap<>();
        for (int i = 0; i < lists.length; i++) {
            if (Objects.nonNull(lists[i])) {
                cursorMap.put(i, lists[i]);
            }
        }
        while (!cursorMap.isEmpty()) {
            ListNode minNode = null;
            int minKey = 0;
            Iterator<Map.Entry<Integer, ListNode>> iterator = cursorMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, ListNode> next = iterator.next();
                ListNode listNode = next.getValue();
                if (Objects.isNull(listNode)) {
                    iterator.remove();
                    continue;
                }
                if (Objects.isNull(minNode) || minNode.val > listNode.val) {
                    minNode = listNode;
                    minKey = next.getKey();
                }
            }
            if (Objects.nonNull(minNode)) {
                cursorMap.put(minKey, minNode.next);
            }
            if (Objects.isNull(head) && Objects.nonNull(minNode)) {
                temp = head = new ListNode(minNode.val);
            } else {
                if (Objects.nonNull(temp)) {
                    temp.next = minNode;
                    temp = temp.next;
                }
            }
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
