package load_balance;

import com.google.common.collect.Lists;
import load_balance.base.LoadBalancer;
import load_balance.base.Node;
import load_balance.weight_round_robin.IncrWRRLoadBalancer;
import load_balance.weight_round_robin.TreeMapWRRLoadBalancer;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class LoadBalancerTest {

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int res = random.nextInt(3);
            System.out.println("random" + res);
        }
    }

    @Test
    public void testRoundRobin() {
        testLoadBalance(Type.ROUND_ROBIN);
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
    public void testIncrWRR() {
        testWeightLoadBalance(Type.INCR_WRR);
    }

    @Test
    public void testTreeMapWRR() {
        testWeightLoadBalance(Type.TREEMAP_WRR);
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
        // 设个默认值
        LoadBalancer loadBalancer = new WeightRandomLoadBalancer(nodes);
        if (type == Type.WEIGHT_RANDOM) {
            loadBalancer = new WeightRandomLoadBalancer(nodes);
        }
        if (type == Type.INCR_WRR) {
            loadBalancer = new IncrWRRLoadBalancer(nodes);
        }
        if (type == Type.TREEMAP_WRR) {
            loadBalancer = new TreeMapWRRLoadBalancer(nodes);
        }
        // 发送请求
        for (int i = 0; i < 1000; i++) {
            Node next = loadBalancer.next();
            next.process("Request " + i);
        }
    }


    private enum Type {
        ROUND_ROBIN, RANDOM, WEIGHT_RANDOM, INCR_WRR, TREEMAP_WRR

    }

}
