package ds.stack;

import java.util.Iterator;

/**
 * Desc: 栈，基于链表实现的，后进先出
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 上午10:12
 */
public class Stack<E> implements Iterable<E> {

    private Node<E> top = null;

    void push(E val) {
        Node<E> newNode = new Node<>(val, null);
        newNode.next = top;
        top = newNode;
    }

    E pop() {
        if (top == null) {
            return null;
        }
        E data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class StackIterator implements Iterator<E> {
        private Node<E> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
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
