package load_balance;

import com.google.common.collect.Lists;
import load_balance.base.LoadBalancer;
import load_balance.base.Node;
import org.junit.Test;

import java.util.List;

public class LoadBalancerTest {

    @Test
    public void testRoundRobin() {
        testLoadBalance(Type.ROUND_ROBIN);
    }

    @Test
    public void testRandom() {
        testLoadBalance(Type.RANDOM);
    }

    @Test
    public void testWeightRoundRobin() {
        testWeightLoadBalance(Type.WEIGHT_ROUND_ROBIN);
    }

    private void testLoadBalance(Type type) {
        // 创建服务节点
        Node node1 = new Node("Node 1");
        Node node2 = new Node("Node 2");
        Node node3 = new Node("Node 3");
        // 创建轮询调度器
        List<Node> nodes = Lists.newArrayList(node1, node2, node3);
        // 设个默认值
        LoadBalancer loadBalancer = new RoundRobinLoadBalancer(nodes);
        if (type == Type.ROUND_ROBIN) {
            loadBalancer = new RoundRobinLoadBalancer(nodes);
        }
        if (type == Type.RANDOM) {
            loadBalancer = new RandomRobinLoadBalancer(nodes);
        }
        // 发送请求
        for (int i = 0; i < 100; i++) {
            Node next = loadBalancer.next();
            next.process("Request " + i);
        }
    }

    private void testWeightLoadBalance(Type type) {
        // 创建服务节点
        Node node1 = new Node("Node 1", 6);
        Node node2 = new Node("Node 2", 1);
        Node node3 = new Node("Node 3", 3);
        // 创建轮询调度器
        List<Node> nodes = Lists.newArrayList(node1, node2, node3);
        // 设个默认值
        LoadBalancer loadBalancer = new WeightedRoundRobinLoadBalancer(nodes);
        if (type == Type.WEIGHT_ROUND_ROBIN) {
            loadBalancer = new WeightedRoundRobinLoadBalancer(nodes);
        }
        // 发送请求
        for (int i = 0; i < 100; i++) {
            Node next = loadBalancer.next();
            next.process("Request " + i);
        }
    }


    private enum Type {
        ROUND_ROBIN, RANDOM, WEIGHT_ROUND_ROBIN,

    }
}
