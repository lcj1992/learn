package linear.linked_list;

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

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
