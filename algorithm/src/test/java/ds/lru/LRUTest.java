package ds.lru;

import org.junit.Test;

import java.util.Objects;

/**
 * Desc:
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 下午4:45
 */
public class LRUTest {

    @Test
    public void test() throws Exception {
        LRUBaseLinkedList<Integer> lru = new LRUBaseLinkedList<>();
        lru.add(1);
        lru.add(2);
        System.out.println(lru);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        System.out.println(lru);
        lru.add(4);
        System.out.println(lru);
        lru.add(6);
        System.out.println(lru);
        lru.add(7);
        System.out.println(lru);
        lru.add(3);
        System.out.println(lru);
    }

    @Test
    public void testCapacity() throws Exception {
        LRUBaseLinkedList<Integer> lru = new LRUBaseLinkedList<>(8);
        lru.add(1);
        lru.add(2);
        System.out.println(lru);
        lru.add(3);
        lru.add(4);
        lru.add(8);
        lru.add(9);
        lru.add(5);
        System.out.println(lru);
        lru.add(4);
        System.out.println(lru);
        lru.add(6);
        System.out.println(lru);
        lru.add(7);
        System.out.println(lru);
        lru.add(3);
        System.out.println(lru);
        lru.add(1);
        System.out.println(lru);
    }

    public static class LRUBaseLinkedList<E> {

        private static final int DEFAULT_CAPACITY = 5;

        private final Node<E> head;

        private int size;

        private final int capacity;

        LRUBaseLinkedList() {
            this.head = new Node<>(null, null);
            this.size = 0;
            this.capacity = DEFAULT_CAPACITY;
        }

        LRUBaseLinkedList(int capacity) {
            this.head = new Node<>(null, null);
            this.size = 0;
            this.capacity = capacity;
        }

        private int size() {
            return size;
        }

        public void add(E data) {
            Node<E> node = find(data);
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
            Node<E> node = head;
            while (Objects.nonNull(node.next.next)) {
                node = node.next;
            }
            node.next = null;
            size--;
        }

        private void addAtHead(E data) {
            head.next = new Node<>(data, head.next);
            size++;
        }

        private Node<E> find(E data) {
            if (head.next == null) {
                return null;
            }
            Node<E> node = head;
            while (Objects.nonNull(node.next)) {
                if (Objects.nonNull(node.data) && Objects.equals(node.data, data)) {
                    return node;
                }
                node = node.next;
            }
            return null;
        }

        private void remove(Node<E> node) {
            Node<E> temp = head;
            while (Objects.nonNull(temp)) {
                if (temp.next == node) {
                    temp.next = temp.next.next;
                    size--;
                    break;
                }
                temp = temp.next;
            }

        }

        private static class Node<E> {
            private final E data;

            private Node<E> next;

            private Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> temp = head;
            while (Objects.nonNull(temp.next)) {
                sb.append(temp.next.data).append(", ");
                temp = temp.next;
            }
            return sb.substring(0, sb.length() - 2);
        }
    }
}
