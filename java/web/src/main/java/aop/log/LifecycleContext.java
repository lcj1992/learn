package aop.log;



import java.util.Objects;

/**
 * Desc: 生命周期上下文
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 2017/2/9
 * Time: 下午8:35
 */
public class LifecycleContext {

    private static final LifecycleContext INSTANCE = new LifecycleContext();
    private final InheritableThreadLocal<Long> tradeNo = new InheritableThreadLocal<>();
    private InheritableThreadLocal<Long> userId = new InheritableThreadLocal<>();
    private InheritableThreadLocal<Long> dealId = new InheritableThreadLocal<>();

    private LifecycleContext() {
    }

    public static LifecycleContext getSingleton() {
        return INSTANCE;
    }

    public void init(long tradeNo) {
        this.tradeNo.set(tradeNo);
    }

    public void init(long tradeNo, long userId, long dealId) {
        this.tradeNo.set(tradeNo);
        this.userId.set(userId);
        this.dealId.set(dealId);
    }

    Long getTradeNo() {
        return tradeNo.get();
    }

    long getUserId() {
        return Objects.isNull(userId.get()) ? 0 : userId.get();
    }

    long getDealId() {
        return Objects.isNull(dealId.get()) ? 0 : dealId.get();
    }

    void clear() {
        tradeNo.remove();
        userId.remove();
        dealId.remove();
    }
}
