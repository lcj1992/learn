package load_balance;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机算法
 */
public class RandomLoadBalancer implements LoadBalancer {
    /**
     * 节点
     */
    private final List<Node> nodes;
    /**
     * 随机数
     */
    private final Random random;

    public RandomLoadBalancer(List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
        this.random = new SecureRandom();
    }

    @Override
    public Node next() {
        int nodeId = random.nextInt(nodes.size());
        return nodes.get(nodeId);
    }
}


