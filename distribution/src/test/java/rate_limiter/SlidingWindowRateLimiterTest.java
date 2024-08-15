package rate_limiter;

import org.junit.Test;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowRateLimiterTest {

    @Test
    public void test() throws InterruptedException {
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(20); // 每分钟最多20个请求
        for (int i = 0; i < 50; i++) {
            System.out.println("Request " + i + ": " + rateLimiter.tryAcquire());
            Thread.sleep(100); // 每次请求之间等待100毫秒
        }
    }

    public static class SlidingWindowRateLimiter {
        private final int windowSizeInMs; // 滑动窗口的大小，以毫秒为单位
        private final int maxRequests; // 允许的最大请求数
        private final Map<Long, AtomicInteger> requestCounts; // 存储每个时间片的请求计数

        public SlidingWindowRateLimiter(int maxRequestsPerMinute) {
            this.windowSizeInMs = 1000 * 60; // 1分钟
            this.maxRequests = maxRequestsPerMinute;
            this.requestCounts = new ConcurrentHashMap<>();
        }

        /**
         * 尝试获取访问令牌。
         *
         * @return 如果允许请求，则返回true；否则返回false。
         */
        public synchronized boolean tryAcquire() {
            Instant now = Instant.now();
            long currentBucket = getBucketForTime(now);

            // 清理过期的时间片
            cleanUpOldBuckets(currentBucket);
            AtomicInteger count = requestCounts.computeIfAbsent(currentBucket, k -> new AtomicInteger());
            return count.incrementAndGet() <= maxRequests;
        }

        /**
         * 根据当前时间计算出对应的时间片ID。
         *
         * @param time 当前时间
         * @return 时间片ID
         */
        private long getBucketForTime(Instant time) {
            // 假设窗口为1分钟，分为10个时间片，每个时间片为6秒
            return time.toEpochMilli() / (windowSizeInMs / 10);
        }

        /**
         * 清理过期的时间片。
         *
         * @param currentBucket 当前时间对应的时间片ID
         */
        private void cleanUpOldBuckets(long currentBucket) {
            requestCounts.entrySet().removeIf(entry -> {
                long bucketId = entry.getKey();
                return currentBucket - bucketId >= 10; // 删除比当前时间早于10个时间片的所有条目
            });
        }
    }
}