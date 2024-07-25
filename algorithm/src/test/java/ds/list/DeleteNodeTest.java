package ds.list;

import common.ListNode;
import common.Utils;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class DeleteNodeTest {

    @Test
    public void test() {
        ListNode listNode = ListNode.createFromArray(4, 5, 1, 9);
        deleteNode(listNode);
        Utils.print(listNode);
    }


    /**
     * 思路
     * 删除这个节点，意味着
     * 1. 这个节点的值等于next节点的值，
     * 2. 这个节点的next指针等于next节点的next指针
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
