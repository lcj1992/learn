package load_balance.weight_round_robin;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 加权轮询算法，轮询指的是对节点的轮询，节点1-节点2-节点3
 * 递增版本
 * weighted round-robin
 */
public class IncrWrrLoadBalancer implements LoadBalancer {
    /**
     * 节点
     */
    private final List<Node> nodes;
    /**
     * 权重总和
     */
    private final int totalWeight;
    /**
     * 随机数
     */
    private final AtomicInteger count;

    public IncrWrrLoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
        this.totalWeight = nodes.stream().mapToInt(Node::getWeight).sum();
        this.count = new AtomicInteger(0);
    }

    public Node next() {
        // [0, totalWeight-1]
        int hit = count.getAndIncrement() % totalWeight;
        int sumWeight = 0;
        for (Node node : nodes) {
            sumWeight += node.getWeight();
            if (sumWeight > hit) {
                return node;
            }
        }
        throw new IllegalStateException();
    }
}
