package linear.lru;

import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午4:08
 */
public class LRUBaseLinkedList<AnyType> {

    private static final int DEFAULT_CAPACITY = 5;

    private Node<AnyType> head;

    private int size;

    private int capacity;

    public LRUBaseLinkedList() {
        this.head = new Node<>(null, null);
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRUBaseLinkedList(int capacity) {
        this.head = new Node<>(null, null);
        this.size = 0;
        this.capacity = capacity;
    }

    private int size() {
        return size;
    }

    public void add(AnyType data) {
        Node<AnyType> node = find(data);
        if (Objects.nonNull(node)) {
            remove(node);
            addAtHead(data);
            return;
        }
        if (size() >= capacity) {
            removeTail();
        }
        addAtHead(data);
    }

    private void removeTail() {
        if (head.next == null) {
            return;
        }
        Node<AnyType> node = head;
        while (Objects.nonNull(node.next.next)) {
            node = node.next;
        }
        node.next = null;
        size--;
    }

    private void addAtHead(AnyType data) {
        Node<AnyType> node = new Node<>(data, head.next);
        head.next = node;
        size++;
    }

    private Node<AnyType> find(AnyType data) {
        if (head.next == null) {
            return null;
        }
        Node<AnyType> node = head;
        while (Objects.nonNull(node.next)) {
            if (Objects.nonNull(node.data) && Objects.equals(node.data, data)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private void remove(Node<AnyType> node) {
        Node<AnyType> temp = head;
        while (Objects.nonNull(temp)) {
            if (temp.next == node) {
                temp.next = temp.next.next;
                size--;
                break;
            }
            temp = temp.next;
        }

    }

    private static class Node<AnyType> {
        private AnyType data;

        private Node<AnyType> next;

        private Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<AnyType> temp = head;
        while (Objects.nonNull(temp.next)) {
            sb.append(temp.next.data + ", ");
            temp = temp.next;
        }
        return sb.toString().substring(0, sb.length() - 2);
    }
}
