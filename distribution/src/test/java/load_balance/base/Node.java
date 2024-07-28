package load_balance.base;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Node {
    /**
     * 节点名称
     */
    private final String name;
    /**
     * 节点权重
     */
    private final Integer weight;
    /**
     * 活跃的连接数
     */
    private final AtomicInteger activeCnt;

    public Node(String name) {
        this(name, 1);
    }

    public Node(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
        this.activeCnt = new AtomicInteger(0);
    }

    public void process(String request) {
        activeCnt.getAndIncrement();
        System.out.println("process " + request + " at " + name);
        activeCnt.getAndDecrement();
    }
}