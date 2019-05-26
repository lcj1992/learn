package hash;

import lombok.Data;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2019/5/6
 * Time: 上午12:29
 */
public class HashTable {

    private Node[] entry;

    public void put(String key, Integer value) {

    }

    public void get(String key) {

    }

    static int hash(String key) {
        return key.hashCode() % 256;
    }

    @Data
    private class Node {
        private String key;
        private Integer value;
        private Node next;
    }
}
