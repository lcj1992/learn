package ds.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Desc: 基于数组实现的线性表
 * ------------------------------------
 * Author:foolchild
 * Date: 2019/3/19
 * Time: 下午9:52
 */
public class MyArrayList<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;

    private E[] theItems;

    MyArrayList() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    // 增
    public void add(E x) {
        add(size(), x);
    }

    public void add(int idx, E x) {
        // 扩容
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    // 删
    public E remove(int idx) {
        E removedItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theItems[size() - 1] = null;
        theSize--;
        return removedItem;
    }

    // 改
    E set(int idx, E newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    // 查
    public E get(int idx) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        E[] old = theItems;
        theItems = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];

        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    // 统计相关
    public int size() {
        return this.theSize;
    }

    private class ArrayListIterator implements Iterator<E> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
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
