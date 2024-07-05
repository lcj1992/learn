package ds.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Desc: 基于双向链表实现的链表
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/19
 * Time: 下午10:26
 */
public class MyLinkedListBaseOnDoublyList<E> implements Iterable<E> {

    private static class Node<E> {
        private Node(E d, Node<E> pre, Node<E> next) {
            this.data = d;
            this.pre = pre;
            this.next = next;
        }

        public E data;
        public Node<E> pre;
        public Node<E> next;

    }

    public MyLinkedListBaseOnDoublyList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
        theSize = 0;
    }

    // 增
    public void add(E x) {
        add(size(), x);
    }

    public void add(int idx, E x) {
        Node<E> node = getNode(idx, 0, size());
        addBefore(node, x);
    }

    // 删
    public E remove(int idx) {
        Node<E> node;
        node = getNode(idx);
        return remove(node);
    }

    private E remove(Node<E> p) {
        p.pre.next = p.next;
        p.next.pre = p.pre;
        theSize--;
        return p.data;
    }

    // 改
    public E set(int idx, E newVal) {
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    // 查
    public E get(int idx) {
        return getNode(idx).next.data;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<>(x, p.pre, p);
        newNode.data = x;
        p.pre.next = newNode;
        p.pre = newNode;
        theSize++;
    }

    // 获取坐标为idx的节点
    private Node<E> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<E> getNode(Node<E> node) {
        Node<E> p = head;
        while (p != tail) {
            if (p.next == node) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    private Node<E> getNode(int idx, int lower, int upper) {
        Node<E> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = head.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = tail;
            for (int i = size(); i > idx; i--) {
                p = p.pre;
            }
        }
        return p;
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head.next;


        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.data;
            current = current.next;
            return nextItem;
        }

        @Override
        public void remove() {
            Node<E> node = getNode(current);
            MyLinkedListBaseOnDoublyList.this.remove(node);

        }
    }

    private int theSize;

    private Node<E> head;

    private Node<E> tail;

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString() {
        Iterator<E> iterator = iterator();
        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(iterator.next());
        }
        return str.toString();
    }
}
