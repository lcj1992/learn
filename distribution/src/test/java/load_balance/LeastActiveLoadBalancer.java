package load_balance;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.util.ArrayList;
import java.util.List;

public class LeastActiveLoadBalancer implements LoadBalancer {
    /**
     * 节点
     */
    private final List<Node> nodes;

    public LeastActiveLoadBalancer(List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }

    @Override
    public Node next() {
        Node leastActiveNode = null;
        int minActiveRequests = Integer.MAX_VALUE;
        for (Node node : nodes) {
            int activeRequestsCount = node.getActiveCnt().get();
            if (activeRequestsCount < minActiveRequests) {
                minActiveRequests = activeRequestsCount;
                leastActiveNode = node;
            }
        }
        return leastActiveNode;
    }
}