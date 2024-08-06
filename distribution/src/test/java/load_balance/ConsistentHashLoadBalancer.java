package load_balance;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConsistentHashLoadBalancer implements LoadBalancer {

    /**
     * 一致性hash环
     */
    private final SortedMap<Long, Node> circle;
    /**
     * 随机数
     */
    private final Random random = new Random();
    /**
     * 虚拟节点的数量
     */
    private static final int VIRTUAL_NODES = 100;

    public ConsistentHashLoadBalancer(List<Node> nodes) {
        this.circle = new ConcurrentSkipListMap<>();
        for (Node node : nodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                long hash = fnv1_32_hash(node.getName() + "-" + i);
                circle.put(hash, node);
            }
        }
    }

    @Override
    public Node next() {
        String key = generateRandomKey();
        long hash = fnv1_32_hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Long, Node> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private String generateRandomKey() {
        return Long.toHexString(random.nextLong());
    }

    private long fnv1_32_hash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (char c : key.toCharArray()) {
            hash = (hash ^ c) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return (hash & 0x7FFFFFFF) + 0x80000000;
    }
}