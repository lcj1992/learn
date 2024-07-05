package ds.list;

import common.Node;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foolchid
 * @date 2024/5/28
 **/
public class CopyRandomListTest {
    @Test
    public void test() {
        Node node1 = new Node(7);
        Node node2 = new Node(13);

        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        Node node = copyRandomList(node1);
        System.out.println(node.val);
    }

    /**
     * 思路一：回溯
     * 1. 通过cachedNode建立原节点与新节点的映射关系
     * 2. 然后设置next和random，此时next和random可能还没建立
     * 3. 递归建立next和random的链表，直至cachedNode包含，则开始回溯
     *
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> cachedNode = new HashMap<>();
        return copyRandomList(head, cachedNode);
    }

    public Node copyRandomList(Node head, Map<Node, Node> cachedNode) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next, cachedNode);
            headNew.random = copyRandomList(head.random, cachedNode);
        }
        return cachedNode.get(head);
    }

    /**
     * 思路2
     * 1. 建立原节点与新节点的映射关系
     * 2. 构建新链表的next和random指向
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 1. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 2. 构建新链表的 next 和 random 指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

    /**
     * 思路3
     * TODO
     * <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/2361362/138-fu-zhi-dai-sui-ji-zhi-zhen-de-lian-b-6jeo">...</a>
     */
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
}
