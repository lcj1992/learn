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
     * 节点
     */
    private final List<Node> nodes;
    /**
     * 权重与节点关系
     * key:
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
        this.nodes = nodes;
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
        //
        return pool.ceilingEntry(hit).getValue();
    }
}
