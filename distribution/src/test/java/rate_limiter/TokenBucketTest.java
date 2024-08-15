package rate_limiter;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketTest {

    @Test
    public void test() throws InterruptedException {
        // 创建一个容量为10，每秒填充1个令牌的令牌桶
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(10, 1);
        // 模拟请求尝试消费令牌
        for (int i = 0; i < 15; i++) {
            System.out.println("Request " + i + ": " + rateLimiter.tryAcquire(1));
            Thread.sleep(100); // 每次请求之间等待900毫秒，以观察令牌的生成和消费
        }
        // 关闭调度器
        rateLimiter.scheduler.shutdown();
    }

    public static class TokenBucketRateLimiter {
        // 桶的容量
        private final int capacity;
        // 当前桶中的令牌数
        private final AtomicInteger tokens;
        private final ScheduledExecutorService scheduler;
        // 每秒填充的令牌数
        private final int refillRate;
        // 填充令牌的时间间隔，以毫秒为单位
        private final long refillPeriod;

        public TokenBucketRateLimiter(int capacity, int refillRate) {
            this.capacity = capacity;
            this.tokens = new AtomicInteger(capacity);
            this.refillRate = refillRate;
            this.refillPeriod = 1000L / refillRate; // 计算每次填充的时间间隔
            this.scheduler = Executors.newScheduledThreadPool(1);
            startRefilling();
        }

        /**
         * 启动定时任务来定期向令牌桶添加令牌。
         */
        private void startRefilling() {
            Runnable refillTask = () -> {
                if (tokens.get() < capacity) {
                    int newTokens = Math.min(tokens.get() + refillRate, capacity);
                    tokens.set(newTokens);
                }
            };
            scheduler.scheduleAtFixedRate(refillTask, 0, refillPeriod, TimeUnit.MILLISECONDS);
        }

        /**
         * 尝试获取指定数量的令牌。
         *
         * @param tokensNeeded 需要的令牌数量
         * @return 是否成功获取令牌
         */
        public synchronized boolean tryAcquire(int tokensNeeded) {
            int currentTokens = tokens.get();
            if (currentTokens >= tokensNeeded) {
                tokens.addAndGet(-tokensNeeded);
                return true;
            }
            return false;
        }
    }
}