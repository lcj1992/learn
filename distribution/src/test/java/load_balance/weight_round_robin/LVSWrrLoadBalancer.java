package load_balance.weight_round_robin;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 加权轮询算法，轮询指的是对节点的轮询，节点1-节点2-节点3
 * 红黑树版本
 * weighted round-robin
 */
public class LVSWrrLoadBalancer implements LoadBalancer {
    /**
     * 节点
     */
    private final List<Node> nodes;
    /**
     * 权重的最大公约数
     */
    private final int gcdWeight;
    /**
     * 权重最大值
     */
    private final int maxWeight;
    /**
     * 请求总数
     */
    private final AtomicInteger count;
    /**
     * 当前权重
     */
    private int currentWeight;

    public LVSWrrLoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
        Integer gcd = null;
        int max = 0;
        for (Node node : nodes) {
            gcd = gcd == null ? node.getWeight() : gcd(gcd, node.getWeight());
            max = Math.max(max, node.getWeight());
        }
        this.gcdWeight = gcd;
        this.maxWeight = max;
        this.count = new AtomicInteger(0);
        this.currentWeight = 0;
    }

    public Node next() {
        while (true) {
            final int n = nodes.size();
            int i = count.getAndIncrement() % n;
            if (i == 0) {
                currentWeight = this.currentWeight - gcdWeight;
                if (currentWeight <= 0) {
                    currentWeight = maxWeight;
                    if (currentWeight == 0) {
                        return null;
                    }
                }
            }
            if (nodes.get(i).getWeight() >= currentWeight) {
                return nodes.get(i);
            }
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
