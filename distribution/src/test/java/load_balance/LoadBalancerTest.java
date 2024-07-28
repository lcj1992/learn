package load_balance;

import com.google.common.collect.Lists;
import load_balance.base.LoadBalancer;
import load_balance.base.Node;
import load_balance.random.RandomLoadBalancer;
import load_balance.random.WeightRandomLoadBalancer;
import load_balance.round_robin.*;
import org.junit.Test;

import java.util.List;

public class LoadBalancerTest {

    @Test
    public void testRoundRobin() {
        testLoadBalance(Type.ROUND_ROBIN);
    }

    @Test
    public void testIncrWRR() {
        testWeightLoadBalance(Type.INCR_WRR);
    }

    @Test
    public void testTreeMapWRR() {
        testWeightLoadBalance(Type.TREEMAP_WRR);
    }

    @Test
    public void testLVSWRR() {
        testWeightLoadBalance(Type.LVS_WRR);
    }

    @Test
    public void testSmoothWRR() {
        testWeightLoadBalance(Type.SMOOTH_MRR);
    }

    @Test
    public void testRandom() {
        testLoadBalance(Type.RANDOM);
    }

    @Test
    public void testWeightRandom() {
        testWeightLoadBalance(Type.WEIGHT_RANDOM);
    }

    @Test
    public void testConsistentHash() {
        testWeightLoadBalance(Type.CONSISTENT_HASH);
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
            loadBalancer = new RandomLoadBalancer(nodes);
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
        LoadBalancer loadBalancer = new WeightRandomLoadBalancer(nodes);
        if (type == Type.WEIGHT_RANDOM) {
            loadBalancer = new WeightRandomLoadBalancer(nodes);
        }
        if (type == Type.INCR_WRR) {
            loadBalancer = new IncrWrrLoadBalancer(nodes);
        }
        if (type == Type.TREEMAP_WRR) {
            loadBalancer = new TreeMapWrrLoadBalancer(nodes);
        }
        if (type == Type.LVS_WRR) {
            loadBalancer = new LVSWrrLoadBalancer(nodes);
        }
        if (type == Type.SMOOTH_MRR) {
            loadBalancer = new SmoothWrrLoadBalancer(nodes);
        }
        if (type == Type.CONSISTENT_HASH) {
            loadBalancer = new ConsistentHashLoadBalancer(nodes);
        }
        // 发送请求
        for (int i = 0; i < 1000; i++) {
            Node next = loadBalancer.next();
            next.process("Request " + i);
        }
    }


    private enum Type {
        ROUND_ROBIN, RANDOM, WEIGHT_RANDOM, INCR_WRR, TREEMAP_WRR, LVS_WRR, SMOOTH_MRR, CONSISTENT_HASH

    }

}
