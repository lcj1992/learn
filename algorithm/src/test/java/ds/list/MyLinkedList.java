package ds.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Desc: 基于链表实现的线性表
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 上午9:25
 */
public class MyLinkedList<E> implements Iterable<E> {
    private static class Node<E> {
        private Node(E d, Node<E> n) {
            data = d;
            next = n;
        }

        public E data;
        public Node<E> next;

    }

    public MyLinkedList() {
        tail = new Node<>(null, null);
        head = new Node<>(null, tail);
        theSize = 0;
    }

    // 增
    public void add(E x) {
        add(size(), x);
    }

    public void add(int idx, E x) {
        Node<E> prev = getPreNode(idx, 0, size());
        addAfter(prev, x);
    }

    // 删
    public E remove(int idx) {
        Node<E> node;
        if (idx == 0) {
            node = head;
        } else {
            node = getPreNode(idx);
        }
        return removeAfter(node);
    }

    private E removeAfter(Node<E> p) {
        E data = p.next.data;
        p.next = p.next.next;
        theSize--;
        return data;
    }

    // 改
    public E set(int idx, E newVal) {
        Node<E> p = getPreNode(idx);
        E oldVal = p.next.data;
        p.next.data = newVal;
        return oldVal;
    }

    // 查
    public E get(int idx) {
        return getPreNode(idx).next.data;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void addAfter(Node<E> p, E x) {
        Node<E> newNode = new Node<>(x, p.next);
        p.next = newNode;
        theSize++;
    }

    // 获取坐标为idx的节点
    private Node<E> getPreNode(int idx) {
        return getPreNode(idx, 0, size() - 1);
    }

    private Node<E> getPreNode(Node<E> node) {
        Node<E> p = head;
        while (p != tail) {
            if (p.next == node) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    private Node<E> getPreNode(int idx, int lower, int upper) {
        Node<E> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (idx == 0) {
            return head;
        }
        p = head;
        for (int i = 0; i < idx; i++) {
            p = p.next;
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
            Node<E> preNode = getPreNode(current);
            MyLinkedList.this.removeAfter(preNode);

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
