package hash;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/6
 * Time: 上午12:29
 */
public class MyHashMap<K, V> {

    private Node<K, V> entry;

    public MyHashMap(Node<K, V> entry) {
        this.entry = entry;
    }

    public void put(K key, V value) {

    }

    public void get(K key) {

    }

    static <K> int hash(K key) {
        return key.hashCode() % 256;
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
    }
}
