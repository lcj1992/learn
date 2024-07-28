package load_balance.round_robin;

import load_balance.base.LoadBalancer;
import load_balance.base.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmoothWrrLoadBalancer implements LoadBalancer {

    final List<Wrr> cachedWeights;

    public SmoothWrrLoadBalancer(List<Node> nodes) {
        this.cachedWeights = nodes.stream().map(Wrr::new).collect(Collectors.toList());
    }

    @Override
    public Node next() {
        int total = 0;
        Wrr shed = cachedWeights.get(0);
        for (Wrr item : cachedWeights) {
            int weight = item.node.getWeight();
            total += weight;
            item.current += weight;
            if (item.current > shed.current) {
                shed = item;
            }
        }
        shed.current -= total;
        return shed.node;
    }

    static class Wrr {
        Node node;
        int current = 0;

        Wrr(Node ele) {
            this.node = ele;
        }
    }
}