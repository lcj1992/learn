package load_balance.weight_round_robin;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.security.SecureRandom;
import java.util.*;


/**
 * 加权轮询算法，轮询指的是对节点的轮询，节点1-节点2-节点3
 * 随机数版本
 * weighted round-robin
 */
public class RandomWRRLoadBalancer implements LoadBalancer {
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
    private final Random random;

    public RandomWRRLoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
        this.totalWeight = nodes.stream().mapToInt(Node::getWeight).sum();
        this.random = new SecureRandom();
    }

    public Node next() {
        // [0, totalWeight-1]
        int hit = random.nextInt(totalWeight);
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
