package load_balance.base;

public interface LoadBalancer {

    /**
     * 返回下一个服务节点
     */
    Node next();
}
