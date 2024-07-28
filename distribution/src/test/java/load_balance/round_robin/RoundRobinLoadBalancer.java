package load_balance.round_robin;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮询算法
 * round-robin
 */
public class RoundRobinLoadBalancer implements LoadBalancer {
    /**
     * 节点
     */
    private final List<Node> nodes;
    /**
     * 当前请求总数
     */
    private final AtomicInteger count;

    public RoundRobinLoadBalancer(List<Node> nodes) {
        this.nodes = nodes;
        this.count = new AtomicInteger(0);
    }

    @Override
    public Node next() {
        // 获取当前索引，并更新当前索引，以便下一次请求调度到下一个服务节点
        int nodeId = this.count.getAndIncrement() % nodes.size();
        return nodes.get(nodeId);
    }
}