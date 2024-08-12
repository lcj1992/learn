package algo.cache;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/">...</a>
 * 最近最少使用算法
 * today
 */
public class LRUTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(3);
        cache.put(5, 5);
        int res = cache.get(5);
        System.out.println(res);
        cache.put(4, 4);
        res = cache.get(5);
        System.out.println(res);

        cache.put(3, 3);
        res = cache.get(5);
        System.out.println(res);

        cache.put(1, 1);
        res = cache.get(5);
        System.out.println(res);

        res = cache.get(4);
        System.out.println(res);

    }

    private static class LRUCache {
        private static class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private final Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private final int capacity;
        private final DLinkedNode head;
        private final DLinkedNode tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    removeTail();
                    size--;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            // 删除哈希表中对应的项
            cache.remove(res.key);
        }
    }
}
