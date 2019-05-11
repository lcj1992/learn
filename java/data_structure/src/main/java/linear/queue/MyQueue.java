package linear.queue;

import java.util.Iterator;

/**
 * Desc: 基于链表实现的先进先出的线性表
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/20
 * Time: 上午11:11
 */
public class MyQueue<E> implements Iterable<E> {
    // 队列的队首和队尾
    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = new Node<>(null, null);

    public MyQueue() {
        tail = new Node<>(null, null);
        head = new Node<>(null, tail);
    }

    public void enqueue(E val) {
        Node<E> newTail = new Node<>(null, null);
        tail.data = val;
        tail.next = newTail;
        tail = newTail;
    }

    public E dequeue() {
        E data = head.next.data;
        head = head.next;
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}
