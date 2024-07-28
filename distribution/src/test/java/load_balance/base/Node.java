package load_balance.base;

import lombok.Getter;

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

    public Node(String name) {
        this(name, 1);
    }

    public Node(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public void process(String request) {
        System.out.println("process " + request + " at " + name);
    }
}