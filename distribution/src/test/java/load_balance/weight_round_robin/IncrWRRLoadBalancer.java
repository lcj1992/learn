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
public class IncrWRRLoadBalancer implements LoadBalancer {
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

    public IncrWRRLoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
        this.totalWeight = nodes.stream().mapToInt(Node::getWeight).sum();
        this.count = new AtomicInteger(0);
    }

    public Node next() {
        // [0, totalWeight-1]
        int hit = count.getAndIncrement() % totalWeight;
        int nodeId = nodes.size() - 1;
        for (int i = 0; i < nodes.size(); i++) {
            if (hit < 0) {
                nodeId = i - 1;
                break;
            }
            hit -= nodes.get(i).getWeight();
        }
        return nodes.get(nodeId);
    }
}
