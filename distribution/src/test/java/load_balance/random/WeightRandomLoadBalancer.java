package load_balance.random;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * 加权随机算法
 */
public class WeightRandomLoadBalancer implements LoadBalancer {
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

    public WeightRandomLoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
        this.totalWeight = nodes.stream().mapToInt(Node::getWeight).sum();
        this.random = new SecureRandom();
    }

    public Node next() {
        // [0, totalWeight-1]
        int hit = random.nextInt(totalWeight);
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