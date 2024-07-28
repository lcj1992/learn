package load_balance.weight_round_robin;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 加权轮询算法，轮询指的是对节点的轮询，节点1-节点2-节点3
 * 红黑树版本
 * weighted round-robin
 */
public class TreeMapWRRLoadBalancer implements LoadBalancer {
    /**
     * 权重与节点关系
     * key: 一轮中该节点能处理的最大下标值
     * value: 节点
     */
    private final TreeMap<Integer, Node> pool = new TreeMap<>();
    /**
     * 总权重
     */
    private final int totalWeight;
    /**
     * 随机数
     */
    private final AtomicInteger count;

    public TreeMapWRRLoadBalancer(List<Node> nodes) {
        this.count = new AtomicInteger(0);
        int total = 0;
        for (Node node : nodes) {
            total += node.getWeight();
            pool.put(total - 1, node);
        }
        this.totalWeight = total;
    }

    public Node next() {
        // [0, totalWeight-1]
        int hit = count.getAndIncrement() % totalWeight;
        // key 大于等于hit的最小的entry
        return pool.ceilingEntry(hit).getValue();
    }
}
